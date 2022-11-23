package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.repository.enums.ProductState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
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

    // TODO: BaseEntity 의 내용을 그대로 사용할지 아래처럼 따로 선언할지 결정 필요
    @Column(name = "sys_reg_id")
    private Long sysRegId;

    @Column(name = "sys_reg_at")
    private LocalDateTime sysRegAt;

    @Column(name = "sys_upd_id")
    private Long sysUpdId;

    @Column(name = "sys_upd_at")
    private LocalDateTime sysUpdAt;


    @Builder
    public Product(Long id, String productName, ProductState productState, String productDescription, Integer productPrice, String productImagePath, Boolean isSale, Boolean isShow, String originPlace, Integer stock, Integer minOrderQuantity, Integer maxOrderQuantity, Long sysRegId, LocalDateTime sysRegAt, Long sysUpdId, LocalDateTime sysUpdAt) {
        this.id = id;
        this.productName = productName;
        this.productState = productState;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImagePath = productImagePath;
        this.isSale = isSale;
        this.isShow = isShow;
        this.originPlace = originPlace;
        this.stock = stock;
        this.minOrderQuantity = minOrderQuantity;
        this.maxOrderQuantity = maxOrderQuantity;
        this.sysRegId = sysRegId;
        this.sysRegAt = sysRegAt;
        this.sysUpdId = sysUpdId;
        this.sysUpdAt = sysUpdAt;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }


    public void createProduct(){

    }
}
