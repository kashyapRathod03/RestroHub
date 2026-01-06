//com/restrohub/qrmenu/order/service/impl/OrderServiceImpl.java
package com.restrohub.qrmenu.order.service.impl;

import com.restrohub.qrmenu.branch.entity.Branch;
import com.restrohub.qrmenu.branch.repository.BranchRepository;
import com.restrohub.qrmenu.common.enums.OrderStatus;
import com.restrohub.qrmenu.common.exception.ResourceNotFoundException;
import com.restrohub.qrmenu.food.entity.Food;
import com.restrohub.qrmenu.food.repository.FoodRepository;
import com.restrohub.qrmenu.order.builder.OrderDirector;
import com.restrohub.qrmenu.order.dto.*;
import com.restrohub.qrmenu.order.entity.Order;
import com.restrohub.qrmenu.order.mapper.OrderMapper;
import com.restrohub.qrmenu.order.repository.OrderRepository;
import com.restrohub.qrmenu.order.service.OrderService;
import com.restrohub.qrmenu.order.service.OrderNotificationService;
import com.restrohub.qrmenu.table.entity.Tables;
import com.restrohub.qrmenu.table.repository.TablesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

private final OrderRepository orderRepository = null;
	private final BranchRepository branchRepository = null;
	private final TablesRepository tableRepository = null;
	private final FoodRepository foodRepository = null;
	private final OrderDirector orderDirector = new OrderDirector();
	private final OrderMapper orderMapper = new OrderMapper();
	private final OrderNotificationService notificationService = new OrderNotificationService();

	@Override
	public OrderResponse createOrder(CreateOrderRequest request) {
//		log.info("Creating order for branch: {}, table: {}", request.getBranchId(), request.getTableId());

		// Fetch branch
		Branch branch = branchRepository.findByBranchIdAndIsDeleteFalse(request.getBranchId())
				.orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + request.getBranchId()));

		// Fetch table
		Tables table = tableRepository.findByTableIdAndIsActiveTrue(request.getTableId())
				.orElseThrow(() -> new ResourceNotFoundException("Table not found with id: " + request.getTableId()));

		// Fetch all food items
		List<Long> foodIds = request.getItems().stream().map(OrderItemRequest::getFoodId).collect(Collectors.toList());

		List<Food> foods = foodRepository.findByFoodIdInAndIsDeleteFalse(foodIds);

		if (foods.size() != foodIds.size()) {
			throw new ResourceNotFoundException("One or more food items not found");
		}

		// Build order using Builder Pattern
		Order order = orderDirector.buildOrderFromRequest(request, branch, table, foods);

		// Save order
		Order savedOrder = orderRepository.save(order);
//     log.info("Order created successfully with id: {}", savedOrder.getOrderId());

		// Send notification to admin
		notificationService.notifyNewOrder(savedOrder);

		return orderMapper.toResponse(savedOrder);
	}

	@Override
	@Transactional(readOnly = true)
	public OrderResponse getOrderById(Long orderId) {
		Order order = findOrderById(orderId);
		return orderMapper.toResponse(order);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderResponse> getOrdersByBranch(Long branchId) {
		List<Order> orders = orderRepository.findByBranchBranchIdOrderByCreatedAtDesc(branchId);
		return orders.stream().map(orderMapper::toResponse).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderResponse> getActiveOrdersByBranch(Long branchId) {
		List<OrderStatus> activeStatuses = Arrays.asList(OrderStatus.PENDING, OrderStatus.CONFIRMED,
				OrderStatus.PREPARING, OrderStatus.READY);

		List<Order> orders = orderRepository.findActiveOrdersByBranch(branchId, activeStatuses);
		return orders.stream().map(orderMapper::toResponse).collect(Collectors.toList());
	}

	@Override
	public OrderResponse updateOrderStatus(Long orderId, OrderStatus status) {
		Order order = findOrderById(orderId);
		order.setStatus(status);
		Order updatedOrder = orderRepository.save(order);

//     log.info("Order {} status updated to {}", orderId, status);

		// Notify about status change
		notificationService.notifyOrderStatusChange(updatedOrder);

		return orderMapper.toResponse(updatedOrder);
	}

	@Override
	public void cancelOrder(Long orderId) {
		Order order = findOrderById(orderId);
		order.setStatus(OrderStatus.CANCELLED);
		orderRepository.save(order);
//     log.info("Order {} cancelled", orderId);
	}

	private Order findOrderById(Long orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
	}
}