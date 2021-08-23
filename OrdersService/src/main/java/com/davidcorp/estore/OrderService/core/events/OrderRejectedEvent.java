package com.davidcorp.estore.OrderService.core.events;

import com.davidcorp.estore.OrderService.core.model.OrderStatus;
import lombok.Value;

@Value
public class OrderRejectedEvent {

    private final String orderId;
    private final String reason;
    private final OrderStatus orderStatus = OrderStatus.REJECTED;
}
