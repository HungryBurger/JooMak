package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "SKUOptionMapping")
@Getter
//@Builder
@EqualsAndHashCode(callSuper = false)
public class SKUOptionMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_option_mapper_id")
    private Long id;

    @Column(name = "sku_id")
    private Long skuId;

    @Column(name = "option_id")
    private Long optionId;

}
