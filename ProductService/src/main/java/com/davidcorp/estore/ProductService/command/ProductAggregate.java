package com.davidcorp.estore.ProductService.command;

import com.davidcorp.estore.ProductService.core.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    public ProductAggregate() {

    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        // Validate Create Product Command

        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equal than zero");
        }

        if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        // Create new ProductCreatedEvent class instance
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        // Copy the values of the source object(createProductCommand) to a destination object(productCreatedEvent)
        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
        
        AggregateLifecycle.apply(productCreatedEvent);
    }

}
