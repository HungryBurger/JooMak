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
	
	//메뉴명
	@Column(name = "menu_nm")
	private String menuNm;
	//메뉴코드
	@Column(name = "menu_code")
	private String menuCode;
	
	@Embedded	// 컬럼을 하나의 객체로 사용하기
    @JoinColumn(name = "store_id")
    private Store store;
	
	//판매상태
	@Enumerated(EnumType.STRING)
    private MenuStatus menuStatus;
	//판매가(정가)
	private int price;
	
	//메뉴그룹ID
	@Embedded
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "menu_grp_id")
	private MenuGroup menugroup;
	
	//옵션그룹 매핑? 메뉴:옵션그룹 = 1:n ? 양방향 ?
	@OneToMany(mappedBy = "opt_grp_id")
	private List<MenuOptionGroup> optionGroupList;
	//재고 매핑? 1:1 ?
	@OneToOne(fetch = LAZY, cascade = Cascade)
	private Stock stock;
	//메뉴 이미지 매핑? 1:1 ?
	@OneToOne(fetch = LAZY, cascade = Cascade)
	private MenuImage menuImage;
	
	//메뉴구성
	@Column(name = "menu_component")
	private String menuComponent;
	//메뉴설명
	@Column(name = "menu_description")
	private String menuDescription;
	
	//주문안내문구
	@Column(name = "order_information")
	private String orderInformation;
	//대표메뉴여부
	@Column(name = "main_yn")
	private String mainYn;
	//옵션사용여부
	@Column(name = "opt_yn")
	private String optYn;
	
	//최소주문수량
	@Column(name = "min_order_quantity")
	private int minOrderQuantity;
	//최대주문수량
	@Column(name = "max_order_quantity")
	private int maxOrderQuantity;
	//원산지
	@Column(name = "country_id")
	private int country_id;
	//판매시작일
	@Column(name = "sales_start_at")
    private LocalDateTime salesStartAt;
	//판매종료일
	@Column(name = "sales_end_at")
    private LocalDateTime salesEndAt;
	
	//태그뱃지 
	@Column(name = "tag_badge")
	private String tagBadge;
	//사용여부
	@Column(name = "use_yn")
	private String useYn;
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
