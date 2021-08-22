package com.davidcorp.estore.OrderService.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class OrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    

}
