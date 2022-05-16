package com.joomak.backend.model.member.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StoreGoodsMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_goods_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public StoreGoodsMapping(Long id, Store store, Product product) {
        this.id = id;
        this.store = store;
        this.product = product;
    }
}
