package com.davidcorp.estore.OrderService.core.data;

import com.davidcorp.estore.OrderService.core.model.OrderStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = -227264951080660124L;

    @Id
    @Column(unique = true)
    public String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
