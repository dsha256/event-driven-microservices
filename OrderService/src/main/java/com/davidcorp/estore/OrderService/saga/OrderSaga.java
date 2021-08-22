package com.davidcorp.estore.OrderService.saga;

import com.davidcorp.estoe.core.commands.ReservedProductCommand;
import com.davidcorp.estoe.core.events.ProductReservedEvent;
import com.davidcorp.estore.OrderService.core.events.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.CommandResultMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class OrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSaga.class);

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {

        ReservedProductCommand reservedProductCommand = ReservedProductCommand.builder()
                .orderId(orderCreatedEvent.getOrderId())
                .productId(orderCreatedEvent.getProductId())
                .quantity(orderCreatedEvent.getQuantity())
                .userId(orderCreatedEvent.getUserId())
                .build();

        LOGGER.info("OrderCreatedEvent handled for orderId: " + reservedProductCommand.getOrderId() +
                " and productId: " + reservedProductCommand.getProductId());

        commandGateway.send(reservedProductCommand, new CommandCallback<ReservedProductCommand, Object>() {
            @Override
            public void onResult(CommandMessage<? extends ReservedProductCommand> commandMessage, CommandResultMessage<?> commandResultMessage) {
                if (commandResultMessage.isExceptional()) {
                    // Start a compensating transaction
                }
            }
        });
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void on(ProductReservedEvent productReservedEvent) {
        // Process user payment
        LOGGER.info("ProductReservedEvent is called for productId: " + productReservedEvent.getProductId() +
                " and orderId: " + productReservedEvent.getOrderId());
    }
}
