package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table
public class MenuCategory {

    @Id
    @GeneratedValue
    @Column(name = "menu_category_id")
    private Long id;
    
    @Embedded
    @JoinColumn(name = "store_id")
    private Store store;
    
    @Column(name = "menu_category_nm")
    private String menuCategoryNm;
    
    @Column(name = "menu_category_description")
    private String menuCategoryDescription;
    
    @Column(name = "menu_category_srt")
    private int menuCategorySrt;
    
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
