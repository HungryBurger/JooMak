package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.product.enums.OptionGroupType;
import com.joomak.backend.model.product.enums.OptionState;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "OptionGroup")
@Getter
//@Builder
@EqualsAndHashCode(callSuper = false)
public class OptionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opt_grp_id")
    private Long id;

    @Column(name = "option_group_name")
    private String optionGroupName;

    @Column(name = "option_group_type")
    private OptionGroupType optionGroupType;

    @Column(name = "option_state")
    private OptionState optionState;

    @Column(name = "option_max_selection")
    private Integer optionMaxSelection;

    @Column(name = "option_min_selection")
    private Integer optionMinSelection;

    @Column(name = "is_mandatory")
    private Boolean isMandatory;

}
