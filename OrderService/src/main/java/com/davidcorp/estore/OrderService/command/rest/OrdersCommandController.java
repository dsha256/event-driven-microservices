package com.davidcorp.estore.OrderService.command.rest;

import com.davidcorp.estore.OrderService.OrderStatus;
import com.davidcorp.estore.OrderService.command.CreateOrderCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    public OrdersCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createCommand(@Valid @RequestBody CreateProductRestModel createProductRestModel) {

        CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
                .orderId(UUID.randomUUID().toString())
                .userId("27b95829-4f3f-4ddf-8983-151ba010e35b")
                .productId(createProductRestModel.getProductId())
                .quantity(createProductRestModel.getQuantity())
                .addressId(createProductRestModel.getAddressId())
                .orderStatus(OrderStatus.CREATED).build();

        String returnValue;

        returnValue = commandGateway.sendAndWait(createOrderCommand);
        return returnValue;
    }
}
