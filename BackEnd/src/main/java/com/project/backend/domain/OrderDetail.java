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
public class OrderDetail {
    @Id
    @GeneratedValue
    @Column(name = "order_dtl_id")
    private String id;

    @ManyToOne(fetch = LAZY)
    private OrderBase orderBase;

    // 이거 없어도 될 것 같은데 예슬쌤과 논의
    // private int sequence;

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
