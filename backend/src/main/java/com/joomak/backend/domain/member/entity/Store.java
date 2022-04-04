package com.joomak.backend.domain.member.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    private String storeName;

    private Double grade;

    private String previewStoreIntro;

    private String businessHour;

    private String mainComment;

    private String subComment;

    private int minOrderPrice;

    @Builder
    public Store(Long id, Member member, String storeName, Double grade, String previewStoreIntro, String businessHour, String mainComment, String subComment, int minOrderPrice) {
        this.id = id;
        this.member = member;
        this.storeName = storeName;
        this.grade = grade;
        this.previewStoreIntro = previewStoreIntro;
        this.businessHour = businessHour;
        this.mainComment = mainComment;
        this.subComment = subComment;
        this.minOrderPrice = minOrderPrice;
    }
}
