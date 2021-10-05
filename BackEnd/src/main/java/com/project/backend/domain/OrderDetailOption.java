package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table
public class OrderDetailOption {
    @Id
    @GeneratedValue
    @Column(name = "order_dtl_option")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_dtl_id")
    private OrderDetail orderDetail; // 주인 장바구니

    private int opt_id; // 옵션 id

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
