package com.joomak.backend.model.member.entity;


import com.joomak.backend.model.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Requirement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="requirement_id")
    private Long id;

    @OneToOne
    @JoinColumn(name ="member_delivery_address_id")
    private Address address;

    //주인 요청사항
    private String hostInquiry;

    //배달기사 요청사항
    private String deliveryManInquiry;

}
