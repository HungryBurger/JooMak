package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table
public class OrderBase {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private String id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "mbr_id")
    private Member member;

    @OneToOne(fetch=LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="order_evaluate_id")
    private OrderEvaluate orderEvaluate;

    @OneToMany(mappedBy = "order_detail_id")
    private List<OrderDetail> orderDetail;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String riderRequire;
    private String ownerRequire;
    //주문 완성 시간
    private LocalDateTime orderCompleteAt;
    //주문 취소 시간
    private LocalDateTime orderCancelAt;
    //주문 배송 시작 시간
    private LocalDateTime orderDlvrStartAt;
    //주문 배송 완료 시간
    private LocalDateTime orderDlvrCompleteAt;

    //가게 정보
    //@OneToOne
    //private Store store;

    //가게 정보
    //@OneToOne
    //private Rider rider;

    @Embedded
    private Address address;

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
