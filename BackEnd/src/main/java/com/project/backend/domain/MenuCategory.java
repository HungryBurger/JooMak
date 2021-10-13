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
	private Long menuCategoryId;
	
	//메뉴ID로 매핑해줘야하는 것 아닐지? - ERD 테이블에 없음
	//일단 추가
	@OneToMany(mappedBy = "menu_id")
	private List<Menu> menuList;

	//매장 : 메뉴 = 1:n ?
	@Embedded //?
	@ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
	
	//메뉴그룹명
	@Column(name = "menu_category_nm")
	private String menuCategoryNm;
	//메뉴그룹설명
	@Column(name = "menu_category_description")
	private String menuCategoryDescription;
	//메뉴그룹순서
	@Column(name = "menu_category_srt")
	private int menuCategorySrt;
	//삭제여부
	@Column(name = "delYn")
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
