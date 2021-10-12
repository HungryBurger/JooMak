package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberBanned {

    //회원번호
    @Id
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    //밴 여부
    @Column(name="banned_yn")
    private String bannedYn;

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
