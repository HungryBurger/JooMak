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

    @ManyToOne(fetch = LAZY)
    private OrderBase orderBase;

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
