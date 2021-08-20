package com.davidcorp.estore.ProductService.command;

import com.davidcorp.estore.ProductService.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventHandler {

    @EventHandler
    public void on(ProductCreatedEvent event) {
        
    }

}
