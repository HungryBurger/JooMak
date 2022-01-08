package com.joomak.backend.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class MemberDeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="mbr_dlv_adr_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mbr_id")
    private Member member;

}

