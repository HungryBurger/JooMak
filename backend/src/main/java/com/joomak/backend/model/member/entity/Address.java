package com.joomak.backend.model.member.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {

    private String city;
    //지번주소
    private String street;
    private String postCode;

    private boolean isMainDeliveryAddress;

    @Builder
    public Address(String city, String street, String postCode, boolean isMainDeliveryAddress) {
        this.city = city;
        this.street = street;
        this.postCode = postCode;
        this.isMainDeliveryAddress = isMainDeliveryAddress;
    }
}
