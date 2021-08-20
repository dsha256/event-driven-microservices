package com.davidcorp.estore.ProductService.query;

import com.davidcorp.estore.ProductService.core.data.ProductsRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductsQueryHandler {

    private final ProductsRepository productsRepository;

    public ProductsQueryHandler(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
}
