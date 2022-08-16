package com.joomak.backend.model.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressInfo {
    private String city;

    private String street;
    private String postCode;
    private boolean isMainDeliveryAddress;
    @Builder
    public AddressInfo(String city, String street, String postCode, boolean isMainDeliveryAddress) {
        this.city = city;
        this.street = street;
        this.postCode = postCode;
        this.isMainDeliveryAddress = isMainDeliveryAddress;
    }
}
