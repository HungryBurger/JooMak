package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MgListImage {

    @Id @GeneratedValue
    @Embedded
    @ManyToOne
    @Joinolumn(name = "mg_list_id")   // 외래키
    private MgList mgList;

    @Column(name = "mg_img_seq")
    // img_sequence
    private int mgImgSeq;

    @Column(name = "mg_list_img_path")
    // 맛객 일지 이미지 경로
    private String mgListImgPath;

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