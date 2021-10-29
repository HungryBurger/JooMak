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
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    @Id
    @GeneratedValue
    private Long dormantSeq;

    //휴면상태 시작일
    // aquery에는 String으로 되어있지만 등록일/자 수정일/자가
    //int 형인것으로 보아 int형으로 하는게 맞는 느낌...
    //하지만 aquery ERD에 기재된대로 일단 따르겠습니다..
    private String dormantStrtDt;

    //휴면상태 종료일
    private String dormantEndDt;

    //등록자
    private int sysRegId;
    //등록일
    private int sysRegAt;
    //수정자
    private int sysUpdId;
    //수정일
    private int sysUpdAt;
}
