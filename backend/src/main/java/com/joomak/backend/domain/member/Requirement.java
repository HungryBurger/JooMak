package com.joomak.backend.domain.member;


import com.joomak.backend.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
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
