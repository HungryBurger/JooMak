package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.product.enums.ProductState;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@Getter
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", updatable = false)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_state")
    private ProductState productState;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "product_image_path")
    private String productImagePath;

    @Column(name = "is_sale")
    private Boolean isSale;

    @Column(name = "is_show")
    private Boolean isShow;

    @Column(name = "origin_place")
    private String originPlace;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "min_order_quantity")
    private Integer minOrderQuantity;

    @Column(name = "max_order_quantity")
    private Integer maxOrderQuantity;

    // TODO: 무분별한 Setter대신 Builder Pattern 사용하기
    // TODO: 사용할 때 단점이나 장점에 대해 찾아보면서 사용하기
    @Builder
    public Product() {

    }

    // TODO: Setter 변경 가능한 애들만 직접 선언
    
    
    // TODO: 도메인 주도 개발 vs 서비스 중심 개발
}
