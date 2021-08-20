package com.davidcorp.estore.ProductService.core.data;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = -227264951080660124L;

    @Id
    @Column(unique = true)
    private String productId;

    @Column(unique = true)
    private String title;
    private BigDecimal price;
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;

        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return 335418294;
    }
}
