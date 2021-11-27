package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity		// JPA
@Getter
@Setter
@Table
public class Inventory {

    @Id
    @GeneratedValue		// SEQ
    @Column(name = "inventory_id")
    private Long id;
    
    @Embedded
    @JoinColumn(name = "menu_id")
    private MenuBase menu;

    @Column(name = "inventory_quantity")
    private int inventoryQuantity;

    @Column(name = "safety_inventory")
    private int safetyInventory;
    
    @Column(name = "sys_reg_id")
    private int sysRegId;
    
    @Column(name = "sys_reg_at")
    private LocalDateTime sysRegAt;
    
    @Column(name = "sys_upd_id")
    private int sysUpdId;
    
    @Column(name = "sys_upd_at")
    private LocalDateTime sysUpdAt;
}
