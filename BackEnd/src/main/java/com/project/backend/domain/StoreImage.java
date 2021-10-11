package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class StoreImage {

    @Id @GeneratedValue
    @Embedded
    @ManyToOne
    @Joinolumn(name = "store_id")   // 외래키
    private Store store;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_img_seq")
    // img_sequence
    private int storeImgSeq;

    @Column(name = "store_img_path")
    // 가게 이미지
    private String storeImgPath;

    @Column(name = "display_seq")
    // 전시 순서
    private int displaySeq;

    @Column(name = "display_yn")
    // 전시 여부
    private String displayYn;

    @Column(name = "store_main_img")
    // 가게 메인 사진
    private String storeMainImg;

    @Column(name = "store_profile_img")
    // 가게 프로필 사진
    private String storeProfileImg;

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