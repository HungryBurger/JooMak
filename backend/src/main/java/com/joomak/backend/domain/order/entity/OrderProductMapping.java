package com.joomak.backend.domain.order.entity;


import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.product.Product;
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
    @Column(name = "orderProductMappingId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
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
