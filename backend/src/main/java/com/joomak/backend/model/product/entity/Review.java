package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "order_id")
    private Integer orderid;


}
