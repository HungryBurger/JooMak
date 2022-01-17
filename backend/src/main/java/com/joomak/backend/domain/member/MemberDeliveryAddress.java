package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class MemberDeliveryAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberDeliveryAddress")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    private String parcelBasedAddress;

    private String parcelBasedAddressDetail;

    private String roadBasedAddress;

    private String roadBasedAddressDetail;

    private String postCode;

    private char isMainDeliveryAddress;

}

