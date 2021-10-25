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
	@ManyToOne(fetch = LAZY)
	//양방향이어야 하는지 ?
	@JoinColumn(name = "opt_grp_id")
	private MenuOptionGroup menuOptionGroup;
	
	//옵션명
	@Column(name = "opt_nm")
	private String optNm;
	//옵션가격
	@Column(name = "opt_price")
	private String optPrice;
	//옵션순서
	@Column(name = "opt_srt")
	private String optSrt;
	
	//사용여부
	@Column(name = "useYn")
	private int useYn;
	//삭제여부
	@Column(name = "del_yn")
	private int delYn;
		
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
