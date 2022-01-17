package com.joomak.backend.domain.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storeId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    private String storeName;

    private Double grade;

    private String previewStoreIntro;

    private String businessHour;

    private String mainComment;

    private String subComment;
}
