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

@Entity
@Getter
@Setter
@Table
public class MenuOptionDetail {

    @Id @GeneratedValue
    @Column(name = "opt_id")
    private Long id;
    
    @Embedded
    @JoinColumn(name = "opt_grp_id")
    private MenuOptionGroup menuOptionGroup;
    
    @Column(name = "opt_nm")
    private int optNm;
    
    @Column(name = "opt_price")
    private String optPrice;
    
    @Column(name = "opt_srt")
    private String optSrt;
    
    @Column(name = "useYn")
    private int useYn;
    
    @Column(name = "del_yn")
    private int delYn;
    
    @Column(name = "sys_reg_id")
    private int sysRegId;
    
    @Column(name = "sys_reg_at")
    private LocalDateTime sysRegAt;
    
    @Column(name = "sys_upd_id")
    private int sysUpdId;
    
    @Column(name = "sys_upd_at")
    private LocalDateTime sysUpdAt;
}
