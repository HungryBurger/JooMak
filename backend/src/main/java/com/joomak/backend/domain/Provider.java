package com.joomak.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Provider {

    //회원번호
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    @Id
    @GeneratedValue
    private Long providerSeq;

    //구글/네이버구분
    private String snsType;

    //이름
    private String snsName;

    //이메일
    private String snsEmail;

    //생년월일
    private String snsBirth;

    //성별
    private String snsGender;

    //연령대
    private String snsAge;

    //등록자
    private int sysRegId;

    //등록일
    private int sysRegAt;

    //수정자
    private int sysUpdId;

    //수정일
    private int sysUpdAt;

    private String uid;
}
