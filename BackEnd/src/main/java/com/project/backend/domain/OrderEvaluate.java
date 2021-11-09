package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
@Table
public class OrderEvaluate {
    @Id
    @GeneratedValue
    @Column(name = "order_evaluate_id")
    private String id;

    @OneToOne(mappedBy = "order_evaluate", fetch = FetchType.LAZY)
    private OrderBase order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "mbr_id")
    private Member member;

    private double order_rating;

    private String order_comment;

    private String order_evaluate_img;

    private char del_yn;

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
