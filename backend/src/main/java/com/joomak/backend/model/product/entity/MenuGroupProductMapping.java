package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "MenuGroupProductMapping")
@Getter
//@Builder
@EqualsAndHashCode(callSuper = false)
public class MenuGroupProductMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_group_product_mapping_id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "menu_group_id")
    private Long menuGroupProductMappingId;

    @Column(name = "menu_sequence")
    private Integer menuSequence;

    @Column(name = "is_main_menu")
    private Boolean isMainMenu;

}
