package com.project.backend.domain;

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

    @ManyToOne(fetch = LAZY)
    private OrderBase orderBase;

    // 이거 없어도 될 것 같은데 예슬쌤과 논의
    // private int sequence; // 이거 다른 팀 테이블이랑 연관되었던 것 같은 데 잘 기억이 안남,,

    // 요거 추가 했는데 맞을까요??
    @OneToMany(mappedBy = "order_detail", cascade = CascadeType.ALL)
    private List<OrderDetailOption> orderDetailOptions = new ArrayList<>();

    /**
     * @OneToOne
     * private Goods goods
     */

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;



}
