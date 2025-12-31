// com/restrohub/qrmenu/order/builder/OrderBuilder.java
package com.restrohub.qrmenu.order.builder;

import com.restrohub.qrmenu.branch.entity.Branch;
import com.restrohub.qrmenu.common.enums.OrderStatus;
import com.restrohub.qrmenu.order.entity.Order;
import com.restrohub.qrmenu.order.entity.OrderItem;
import com.restrohub.qrmenu.table.entity.Tables;
import java.util.List;

public interface OrderBuilder {
    
    OrderBuilder withBranch(Branch branch);
    
    OrderBuilder withTable(Tables table);
    
    OrderBuilder withCustomerName(String customerName);
    
    OrderBuilder withCustomerPhone(String customerPhone);
    
    OrderBuilder withSpecialInstructions(String instructions);
    
    OrderBuilder withStatus(OrderStatus status);
    
    OrderBuilder addOrderItem(OrderItem item);
    
    OrderBuilder addOrderItems(List<OrderItem> items);
    
    Order build();
    
    void reset();
}