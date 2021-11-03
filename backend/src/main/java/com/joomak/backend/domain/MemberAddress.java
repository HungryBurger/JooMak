package com.joomak.backend.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class MemberAddress {

    //Member 테이블 참조하는 회원번호
//    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mbr_id")
    private Member mbrId;

    //sequence
    @Id @GeneratedValue
    private Long addressSeq;

    //지번 기본주소
    private String parcelBasedAddress;

    //지번 상세주소
    private String parcelBasedAddressDetail;

    //도로명 기본주소
    private String roadBasedAddress;

    //도로명 상세주소
    private String roadBasedAddressDetail;

    //우편번호
    private String postCode;

    //등록자
    private int sysRegId;
    //등록일
    private int sysRegAt;
    //수정자
    private int sysUpdId;
    //수정일
    private int sysUpdAt;

    //대표배송지 여부(대표배송지이냐 아니냐?)
    @Column(name="main_dlvr_address_yn")
    private char mainDlvrAddressYn;
}
