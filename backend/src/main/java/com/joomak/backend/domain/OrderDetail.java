package com.joomak.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table
public class OrderDetail {
    @Id
    @GeneratedValue
    @Column(name = "order_dtl_id")
    private String id;

    // @XToOne(OneToOne, ManyToOne) 관계는 기본이 즉시로딩이므로 직접 지연로딩으로 설정해야 한
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // casecade.ALL : 단일 Entity에 완전히 종속적일 때 사용하면 괜찮다.
//    @JoinColumn(name = "order_id")
    private OrderBase order; //주문

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "menu_id")
    private MenuBase menu;

    private int goodsCount;

    private long totalPrice;

    private int opt_id;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<OrderDetailOption> options = new ArrayList<>();

    private String sizeOption; //?? string? int?

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;



}
