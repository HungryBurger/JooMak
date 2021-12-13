package com.joomak.backend.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity		// JPA
@Getter
@Setter
@Table
public class Stock {

    @Id @GeneratedValue		// SEQ
    @Column(name = "stock_id")
    private Long id;

//    @Embedded
//    @JoinColumn(name = "menu_id")
//    private MenuBase menu;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "safety_stock")
    private int safetyStock;

    @Column(name = "sys_reg_id")
    private int sysRegId;

    @Column(name = "sys_reg_at")
    private LocalDateTime sysRegAt;

    @Column(name = "sys_upd_id")
    private int sysUpdId;

    @Column(name = "sys_upd_at")
    private LocalDateTime sysUpdAt;
}