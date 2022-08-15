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

}
