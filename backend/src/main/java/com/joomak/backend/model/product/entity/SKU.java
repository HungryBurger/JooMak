package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "SKU")
@Getter
@EqualsAndHashCode(callSuper = false)
public class SKU extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_id")
    private Long skuId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "stock_quantity")
    private String stockQuantity;

    @Column(name = "price")
    private Integer price;

}
