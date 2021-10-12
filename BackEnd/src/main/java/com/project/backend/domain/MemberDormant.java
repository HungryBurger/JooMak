package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberDormant {

    //회원번호
    @Id
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    //휴면상태 시작일
    // aquery에는 String으로 되어있지만 등록일/자 수정일/자가
    //int 형인것으로 보아 int형으로 하는게 맞는 느낌...
    //하지만 aquery ERD에 기재된대로 일단 따르겠습니다.
    @Column(name="dormant_strt_dt")
    private String dormantStrtDt;

    //휴면상태 종료일
    @Column(name="dormant_end_dt")
    private String dormantEndDt;

    //등록자
    @Column(name = "sys_reg_id")
    private int sysRegId;
    //등록일
    @Column(name = "sys_reg_at")
    private int sysRegAt;
    //수정자
    @Column(name = "sys_upd_id")
    private int sysUpdId;
    //수정일
    @Column(name = "sys_upd_at")
    private int sysUpdAt;
}
