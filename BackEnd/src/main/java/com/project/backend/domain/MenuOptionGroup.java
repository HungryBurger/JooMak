package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Embeddable //양방향일 경우 table마다 얘가 필요하게 되는건지 ?
@Table
public class OptionGroup {
	
	@Id
	@GeneratedValue
	@Column(name = "opt_grp_id")
	private Long optGrpId;
	
	@Embedded
	@ManyToOne(fatch = LAZY)
	@JoinColumn(name = "menu_id")
	private MenuBase menubase;
	
	//Menu가 store랑 매핑되었는데, 얘도 store랑 매핑이 필요한지 ?
	@Embedded
    @JoinColumn(name = "store_id")
    private Store store;
	
	//옵션 매핑 양방향 ??
	@OneToMany(mappedBy = "option_id")
	private List<Option> optionList;
	
	//옵션그룹명
	@Column(name = "opt_grp_nm")
	private String optGrpNm;
	
	//옵션필수여부
	@Column(name = "opt_req_yn")
	private String optReqYn;
	//옵션그룹순서
	@Column(name = "opt_grp_srt")
	private int optGrpSrt;
	
	//사용여부
	@Column(name = "use_yn")
	private String useYn;
	//삭제여부
	@Column(name = "del_yn")
	private String delYn;
		
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
