package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Provider {

    //회원번호
    @Id
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    //구글/네이버구분
    @Column(name="sns_type")
    private String snsType;

    //이름
    @Column(name="sns_name")
    private String snsName;

    //이메일
    @Column(name="sns_email")
    private String snsEmail;

    //생년월일
    @Column(name="sns_birth")
    private String snsBirth;

    //성별
    @Column(name="sns_gender")
    private String snsGender;

    //연령대
    @Column(name="sns_age")
    private String snsAge;

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

    @Column(name="uid")
    private String uid;
}
