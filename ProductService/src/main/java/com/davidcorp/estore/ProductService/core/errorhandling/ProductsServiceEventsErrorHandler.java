package com.davidcorp.estore.ProductService.core.errorhandling;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;

public class ProductsServiceEventsErrorHandler implements ListenerInvocationErrorHandler {

    @Override
    public void onError(Exception exception, EventMessage<?> eventMessage, EventMessageHandler eventMessageHandler) throws Exception {
        throw exception;
    }

}
