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
public class MenuImage {

    @Id @GeneratedValue
    @Column(name = "menu_img_id")
    private Long id;
    
    @Embedded
    @JoinColumn(name = "menu_id")
    private MenuBase menu;
    
    @Column(name = "img_srt")
    private int imgSrt;
    
    @Column(name = "org_img_nm")
    private String orgImgNm;
    
    @Column(name = "dir_img_nm")
    private String dirImgNm;
    
    @Column(name = "img_path")
    private int imgPath;
    
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
