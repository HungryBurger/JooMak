package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MgList {

    @Id @GeneratedValue
    @Column(name = "mg_list_id")
    private Long id;

    @ManyToOne
    @Embedded
    @JoinColumn(name = "mbr_id")    // 외래키
    private Member member;

    @OneToOne
    @Embedded
    @JoinColumn(name = "ord_id")    // 외래키
    private Order order;

    // 내용
    private String content;

    @OneToOne
    @Embedded
    @JoinColumn(name = "ord_time")  // 외래키
    private Order order;

    // 별점
    private double grade;

    @ManyToOne
    @Embedded
    @JoinColumn(name = "store_id")  // 외래키
    private Store store;

    @Column(name = "sys_reg_id")
    // 등록자
    private int sysRegId;

    @Column(name = "sys_reg_at")
    // 등록일
    private int sysRegAt;

    @Column(name = "sys_upd_id")
    // 수정자
    private int sysUpdId;

    @Column(name = "sys_upd_at")
    // 수정일
    private int sysUpdAt;
}