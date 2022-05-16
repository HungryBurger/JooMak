package com.joomak.backend.model.order.entity;


import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "Orders")
@NoArgsConstructor(access = PROTECTED)
public class OrderProductMapping extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_mapping_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int productCount;

    @Builder
    public OrderProductMapping(Long id, Order order, Product product, int productCount) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.productCount = productCount;
    }
}
