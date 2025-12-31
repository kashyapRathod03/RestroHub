package com.restrohub.qrmenu.order.service;

import java.util.List;

import com.restrohub.qrmenu.common.enums.OrderStatus;
import com.restrohub.qrmenu.order.dto.CreateOrderRequest;
import com.restrohub.qrmenu.order.dto.OrderResponse;

public interface OrderService {

	OrderResponse createOrder(CreateOrderRequest request);

	OrderResponse getOrderById(Long orderId);

	List<OrderResponse> getOrdersByBranch(Long branchId);

	List<OrderResponse> getActiveOrdersByBranch(Long branchId);

	OrderResponse updateOrderStatus(Long orderId, OrderStatus status);

	void cancelOrder(Long orderId);
}