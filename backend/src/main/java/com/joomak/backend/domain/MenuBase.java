package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity		// JPA
@Getter
@Setter
@Embeddable	// @Embedded 대상일 경우 필요
@Table
public class MenuBase {

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;
    
    @Column(name = "menu_nm")
    private String menu_nm;

    @Column(name = "menu_code")
    private String menu_code;

    @Embedded	// 컬럼을 하나의 객체로 사용하기
    @ManyToOne(fetch = LAZY)	// 단방향인지 확인 필요
    @JoinColumn(name = "store_id")
    private Store store;
    
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
