package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Embeddable
@Table
public class Store {

    @Id @GeneratedValue
    @Column(name = "store_id")
    // 가게 ID
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    // 점주 번호
    private Owner owner;

    @Column(name = "store_nm")
    // 가게 이름
    private String name;

    // 평점
    private double grade;

    @Column(name = "avg_dlvr_time")
    // 평균 배달 시간
    private String avgDlvrTime;

    @Column(name = "preview_store_intro_cmt")
    // 미리보기 내 매장 소개
    private String previewStoreIntroCmt;

    @Column(name = "busineess_hour")
    // 영업 시간
    private String businessHour;

    @Column(name = "merchant_id")
    // 가맹점 번호
    private String merchantId;

    @Column(name = "store_main_cmt1")
    // 가게 메인 코멘트1
    private String storeMainCmt1;

    @Column(name = "store_main_cmt2")
    // 가게 메인 코멘트2
    private String storeMainCmt2;

    @Column(name = "sys_reg_id")
    // 등록자
    private int sysRegId;

    @Column(name = "sys_reg_at")
    // 등록일
    private String sysRegAt;

    @Column(name = "sys_upd_id")
    // 수정자
    private int sysUpdId;

    @Column(name = "sys_upd_at")
    // 수정일
    private String sysUpdAt;

    @OneToMany(mappedBy = "store")  // 참조를 당하는 쪽에서 읽기만 가능
    private List<StoreReview> reviews = new ArrayList<>();

}