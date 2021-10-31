package com.joomak.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberRequirement {

    //회원번호
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    @Id
    @GeneratedValue
    private Long requireSeq;

    //라이더 요청사항
    private String reqToRider;

    //요청사항 고정여부(라이더)
    private String reqRiderYn;

    //사장님께 요청사항
    private String reqToOwner;

    //요청사항 고정여부(사장님)
    private String reqOwnerYn;

    //등록자
    private int sysRegId;

    //등록일
    private int sysRegAt;

    //수정자
    private int sysUpdId;

    //수정일
    private int sysUpdAt;
}
