package com.davidcorp.estore.OrderService.core.events;

import com.davidcorp.estore.OrderService.OrderStatus;
import lombok.Data;

@Data
public class OrderCreatedEvent {

    private  String orderId;
    private  String userId;
    private  String productId;
    private  int quantity;
    private  String addressId;
    private OrderStatus orderStatus;

}
