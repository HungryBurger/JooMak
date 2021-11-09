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
public class CartBase {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private String id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "mbr_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id")
//    private Menu menu;

    private int menu_cnt; // 상품 수량

    private int menu_price; // 상품 가격

    @OneToMany(mappedBy = "cart_base", cascade = CascadeType.ALL)
    private List<CartOption> options = new ArrayList<>();

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
