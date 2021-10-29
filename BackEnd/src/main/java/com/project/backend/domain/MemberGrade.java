package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberGrade {

    //회원번호
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    @Id
    @GeneratedValue
    private Long gradeSeq;

    //회원등급
    private String mbrGrd;

    //등록자
    private int sysRegId;

    //등록일
    private int sysRegAt;

    //수정자
    private int sysUpdId;

    //수정일
    private int sysUpdAt;

    //혜택은 aquery툴에 정의되어있으나 정해진 바 없음.
}
