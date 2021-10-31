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
public class CartBase {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private String id;
    
    private int menu_cnt; // 상품 수량

    private int menu_price; // 상품 가격
    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
