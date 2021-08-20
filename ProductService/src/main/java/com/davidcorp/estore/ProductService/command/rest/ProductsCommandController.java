package com.davidcorp.estore.ProductService.command.rest;

import com.davidcorp.estore.ProductService.command.CreateProductCommand;
import com.davidcorp.estore.ProductService.rest.CreateProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductsCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString()).build();

        String returnValue;

        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception ex) {
            returnValue = ex.getLocalizedMessage();
        }

//        System.out.println(returnValue);
        return returnValue;
    }

//    @GetMapping
//    public String getProduct() {
//        // Test Spring Cloud API Gateway builtin Load Balancer
//        return "HTTP GET Handled " + env.getProperty("local.server.port");
//    }
//
//    @PutMapping
//    public String updateProduct() {
//        return "HTTP PUT Handled";
//    }
//
//    @DeleteMapping
//    public String deleteProduct() {
//        return "HTTP DELETE Handled";
//    }
}
