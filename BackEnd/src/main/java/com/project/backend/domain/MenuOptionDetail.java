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
public class MenuOptionDetail {

    @Id
    @GeneratedValue
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
