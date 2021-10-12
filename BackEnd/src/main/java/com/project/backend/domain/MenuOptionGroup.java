package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Embeddable
@Table
public class MenuOptionGroup {

    @Id
    @GeneratedValue
    @Column(name = "opt_grp_id")
    private Long id;
    
    @Embedded
    @JoinColumn(name = "store_id")
    private Store store;
    
    @Embedded
    @Column(name = "menu_id")
    private MenuBase menu;
    
    @Column(name = "opt_grp_nm")
    private String optGrpNm;
    
    @Column(name = "opt_req_yn")
    private String optReqYn;
    
    @Column(name = "opt_grp_srt")
    private int optGrpSrt;
    
    @Column(name = "use_yn")
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
