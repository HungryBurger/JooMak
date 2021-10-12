package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberAddress {

    //Member 테이블 참조하는 회원번호
    @Id
    @ManyToOne
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    //sequence
    @Column(name="address_seq")
    private int addressSeq;

    //지번 기본주소
    @Column(name="parcel_based_address")
    private String parcelBasedAddress;

    //지번 상세주소
    @Column(name="parcel_based_address_detail")
    private String parcelBasedAddressDetail;

    //도로명 기본주소
    @Column(name="road_based_address")
    private String roadBasedAddress;

    //도로명 상세주소
    @Column(name="road_based_address_detail")
    private String roadBasedAddressDetail;

    //우편번호
    @Column(name="post_code")
    private String postCode;

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

    //대표배송지 여부(대표배송지이냐 아니냐?)
    @Column(name="main_dlvr_address_yn")
    private char mainDlvrAddressYn;
}
