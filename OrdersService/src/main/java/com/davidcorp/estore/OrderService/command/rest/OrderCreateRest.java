package com.davidcorp.estore.OrderService.command.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class OrderCreateRest {

    @NotBlank(message = "Product title is a required field")
    private String productId;

    @Min(value = 1, message = "Quantity can not be lower than 1")
    @Max(value = 5, message = "Quantity can not be larger than 5")
    private Integer quantity;

    @NotBlank(message = "Address ID is a required field")
    private String addressId;

}
