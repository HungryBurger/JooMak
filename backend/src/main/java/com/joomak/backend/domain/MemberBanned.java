package com.joomak.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberBanned {

    //회원번호
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    @Id
    @GeneratedValue
    private Long bannedSeq;

    //밴 여부
    private String bannedYn;

    //등록자
    private int sysRegId;
    //등록일
    private int sysRegAt;
    //수정자
    private int sysUpdId;
    //수정일
    private int sysUpdAt;

}
