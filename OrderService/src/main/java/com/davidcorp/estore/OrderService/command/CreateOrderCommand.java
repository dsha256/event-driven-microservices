package com.davidcorp.estore.OrderService.command;

import com.davidcorp.estore.OrderService.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateOrderCommand {

    private final String orderId;
    private final String userId;
    private final String productId;
    private final int quantity;
    private final String addressId;
    private final OrderStatus orderStatus;

}
