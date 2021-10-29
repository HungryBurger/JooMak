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
public class MenuImage {
	
	@Id
	@GeneratedValue
	@Column(name = "menu_img_id")
	private Long id;
	
	//이미지 : 메뉴 = 1:1 ?
	@Embedded
	@OneToOne(fetch = LAZY, cascade = Cascade)
	@JoinColumn(name = "menu_id")
	private MenuBase menubase;
	
	//이미지순서
	@Column(name = "img_srt")
	private int imgSrt;
	//원본이미지명
	@Column(name = "org_img_nm")
	private String orgImgNm;
	//저장이미지명
	@Column(name = "dir_img_nm")
	private String dirImgNm;
	//저장경로
	@Column(name = "img_path")
	private String imgPath;
	
	//삭제여부
	@Column(name = "del_yn")
	private string delYn;
	
	//등록자
	@Column(name = "sys_reg_id")
	private int sysRegId;
	//등록일
	@Column(name = "sys_reg_at")
	private LocalDateTime sysRegAt;
	//수정자
	@Column(name = "sys_upd_id")
	private int sysUpdId;
	//수정일
	@Column(name = "sys_upd_at")
	private LocalDateTime sysUpdAt;
}
