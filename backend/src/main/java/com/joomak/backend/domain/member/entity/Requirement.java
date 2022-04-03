package com.joomak.backend.domain.member.entity;


import com.joomak.backend.domain.common.BaseEntity;
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
    @Column(name ="requirementId")
    private Long id;

    @OneToOne
    @JoinColumn(name ="requirement")
    private MemberDeliveryAddress memberDeliveryAddress;

    //주인 요청사항
    private String hostInquiry;

    //배달기사 요청사항
    private String deliveryManInquiry;

}
