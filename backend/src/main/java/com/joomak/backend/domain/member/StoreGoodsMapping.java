package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.product.Product;
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
    @Column(name = "storeGoodsId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Builder
    public StoreGoodsMapping(Long id, Store store, Product product) {
        this.id = id;
        this.store = store;
        this.product = product;
    }
}
