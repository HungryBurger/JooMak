package com.joomak.backend.model.member.entity;


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
public class StoreReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_review_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private String reviewLoginId;

    private double reviewRate;

    private String reviewTitle;

    private String reviewContents;

    private int reviewLike;

    private String reviewImagePath;

    public StoreReview(Long id, Store store, String reviewLoginId, double reviewRate, String reviewTitle, String reviewContents, int reviewLike, String reviewImagePath) {
        this.id = id;
        this.store = store;
        this.reviewLoginId = reviewLoginId;
        this.reviewRate = reviewRate;
        this.reviewTitle = reviewTitle;
        this.reviewContents = reviewContents;
        this.reviewLike = reviewLike;
        this.reviewImagePath = reviewImagePath;
    }
}
