package com.davidcorp.estore.ProductService.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "productlookup")
public class ProductLookupEntity implements Serializable {

    private static final long serialVersionUID = 2788007460547645663L;

    @Id
    private String productId;

    @Column(unique = true)
    private String title;

}
