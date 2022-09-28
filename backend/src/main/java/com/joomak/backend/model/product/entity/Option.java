package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.product.enums.OptionState;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Option")
@Getter
//@Builder
@EqualsAndHashCode(callSuper = false)
public class Option extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id", updatable = false)
    private Long id;

    @Column(name = "option_group_id")
    private Long optionGroupId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "option_state")
    private OptionState optionState;

    @Column(name = "option_max_selection")
    private int optionMaxSelection;

    @Column(name = "additional_price")
    private Integer additionalPrice;

    @Column(name = "option_min_selection")
    private int optionMinSelection;

    @Column(name = "is_mandatory")
    private Boolean isMandatory;

}
