package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table
public class OrderDeliveryAddress {
    @Id
    @GeneratedValue
    @Column(name = "order_dlvr_add_id")
    private String id;


    @OneToOne(mappedBy = "order_delivery_address", fetch = FetchType.LAZY)
    private OrderBase orderBase; // 주인 장바구니

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "address_seq")
    private Address address;

    private String parcel_based_address_detail; // 지번 상세 주소

    private String road_based_address_detail;// 도로명 상세 주소

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
