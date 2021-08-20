package com.davidcorp.estore.ProductService.query;

import com.davidcorp.estore.ProductService.core.data.ProductEntity;
import com.davidcorp.estore.ProductService.core.data.ProductsRepository;
import com.davidcorp.estore.ProductService.core.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private ProductsRepository productsRepository;

    public ProductEventsHandler(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productsRepository.save(productEntity);

    }
}
