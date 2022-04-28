package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.common.ProductState;
import com.joomak.backend.model.common.YorN;
import com.joomak.backend.model.member.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated
    private ProductState productState; // SELLING,PAUSE,OVERTIME

    @OneToOne
    @JoinColumn(name="product_image")
    private ProductImage productImage;

    private int price;

    //물품 수량
    private int productCnt;

    private String productDescription;
    //대표 메뉴
    private YorN mainYn;

    //최대주문수량
    private int maxOrderQuantity;
    //최소주문수량
    private int minOrderQuantity;
    //옵션 사용 여부
    private YorN optionYn;

    private LocalDateTime salesStartAt;

    private LocalDateTime salesEndAt;
    //원산지
    private String countryId;

    private YorN useYn;

    private YorN deleteYn;
}
