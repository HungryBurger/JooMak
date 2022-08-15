package com.joomak.backend.model.member.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {
    //지번주소
    private String parcelBasedAddress;

    private String parcelBasedAddressDetail;
    //도로명 주소
    private String roadBasedAddress;

    private String roadBasedAddressDetail;

    private String postCode;

    private boolean isMainDeliveryAddress;

    @Builder
    public Address(String parcelBasedAddress, String parcelBasedAddressDetail, String roadBasedAddress, String roadBasedAddressDetail, String postCode, boolean isMainDeliveryAddress) {
        this.parcelBasedAddress = parcelBasedAddress;
        this.parcelBasedAddressDetail = parcelBasedAddressDetail;
        this.roadBasedAddress = roadBasedAddress;
        this.roadBasedAddressDetail = roadBasedAddressDetail;
        this.postCode = postCode;
        this.isMainDeliveryAddress = isMainDeliveryAddress;
    }
}
