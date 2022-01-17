package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class StoreGoodsMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storeGoodsId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private StoreBase storeBase;

//    @ManyToOne
//    @JoinColumn(name="goodsId")
//    private Goods goods;
//

}
