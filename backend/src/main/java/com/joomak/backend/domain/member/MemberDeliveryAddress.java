package com.joomak.backend.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class MemberDeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mbr_dlvr_addr")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mbr_id")
    private Member member;

    private String parcelBasedAddress;

    private String parcelBasedAddressDetail;

    private String roadBasedAddress;

    private String roadBasedAddressDetail;

    private String postCode;

    private char isMainDeliveryAddress;

    @Embedded
    private SystemInfo systemInfo;

}

