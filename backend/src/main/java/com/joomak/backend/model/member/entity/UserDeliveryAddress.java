package com.joomak.backend.model.member.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.joomak.backend.model.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = PROTECTED)
public class UserDeliveryAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_delivery_address_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //지번주소
    private String parcelBasedAddress;

    private String parcelBasedAddressDetail;
    //도로명 주소
    private String roadBasedAddress;

    private String roadBasedAddressDetail;

    private String postCode;

    private boolean isMainDeliveryAddress;
}
