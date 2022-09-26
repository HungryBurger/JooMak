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
    private Integer optGrpId;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "opt_grp_nm")
    private String optGrpNm;

    @Column(name = "use_yn")
    private String useYn;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "opt_req_yn")
    private String optReqYn;

    @Column(name = "opt_grp_srt")
    private Integer optGrpSrt;

}
