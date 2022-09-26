package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
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
    @Column(name = "opt_id", updatable = false)
    private Integer optId;

    @Column(name = "opt_grp_id")
    private Integer optGrpId;

    @Column(name = "opt_nm")
    private String optNm;

    @Column(name = "opt_price")
    private Integer optPrice;

    @Column(name = "opt_srt")
    private Integer optSrt;

    @Column(name = "use_yn")
    private String useYn;

    @Column(name = "del_yn")
    private String delYn;

}
