package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberRequirement {

    //회원번호
    @Id
    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    //라이더 요청사항
    @Column(name="req_to_rider")
    private String reqToRider;

    //요청사항 고정여부(라이더)
    @Column(name="req_rider_yn")
    private String reqRiderYn;

    //사장님께 요청사항
    @Column(name="req_to_owner")
    private String reqToOwner;

    //요청사항 고정여부(사장님)
    @Column(name="req_owner_yn")
    private String reqOwnerYn;

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
