package com.joomak.backend.domain.member.entity;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.YorN;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class MemberDeliveryAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_delivery_address_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "parcel_based_address")
    private String parcelBasedAddress;

    @Column(name = "parcel_based_address_detail")
    private String parcelBasedAddressDetail;

    @Column(name = "road_based_address")
    private String roadBasedAddress;

    @Column(name = "road_based_address_detail")
    private String roadBasedAddressDetail;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "is_main_delivery_address")
    private YorN isMainDeliveryAddress;

    @Builder
    public MemberDeliveryAddress(Long id, Member member, String parcelBasedAddress, String parcelBasedAddressDetail, String roadBasedAddress, String roadBasedAddressDetail, String postCode, YorN isMainDeliveryAddress) {
        this.id = id;
        this.member = member;
        this.parcelBasedAddress = parcelBasedAddress;
        this.parcelBasedAddressDetail = parcelBasedAddressDetail;
        this.roadBasedAddress = roadBasedAddress;
        this.roadBasedAddressDetail = roadBasedAddressDetail;
        this.postCode = postCode;
        this.isMainDeliveryAddress = isMainDeliveryAddress;
    }
}

