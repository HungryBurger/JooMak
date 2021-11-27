package com.joomak.backend.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity		// JPA
@Getter
@Setter
@Embeddable
@Table
public class MenuBase {

    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long id;
    
    @Column(name = "menu_nm")
    private String menu_nm;

    @Column(name = "menu_code")
    private String menu_code;

//    @Embedded
//    @JoinColumn(name = "store_id")
//    private Store store;
    
    @Enumerated(EnumType.STRING)
    private MenuStatus menuStatus;
    
    @Column(name = "menu_component")
    private String menuComponent;
    
    @Column(name = "menu_description")
    private String menuDescription;
    
    @Column(name = "order_information")
    private String orderInformation;
    
    @Column(name = "main_yn")
    private String mainYn;
    
    @Column(name = "opt_yn")
    private String optYn;
    
    @Column(name = "min_order_quantity")
    private int minOrderQuantity;
    
    @Column(name = "max_order_quantity")
    private int maxOrderQuantity;
    
    @Column(name = "sales_start_at")
    private LocalDateTime salesStartAt;
    
    @Column(name = "sales_end_at")
    private LocalDateTime salesEndAt;
    
    @Column(name = "country_id")
    private String countryId;
    
    @Column(name = "tag_badge")
    private String tagBadge;
    
    @Column(name = "use_yn")
    private String useYn;
    
    @Column(name = "delYn")
    private String delYn;
    
    @Column(name = "sys_reg_id")
    private int sysRegId;
    
    @Column(name = "sys_reg_at")
    private LocalDateTime sysRegAt;
    
    @Column(name = "sys_upd_id")
    private int sysUpdId;
    
    @Column(name = "sys_upd_at")
    private LocalDateTime sysUpdAt;
}
