package com.davidcorp.estore.ProductService.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private Environment env;

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        return "HTTP POST Handled " + createProductRestModel.getTitle();
    }

    @GetMapping
    public String getProduct() {
        // Test Spring Cloud API Gateway builtin Load Balancer
        return "HTTP GET Handled " + env.getProperty("local.server.port");
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP PUT Handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP DELETE Handled";
    }
}
