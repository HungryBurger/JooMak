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
	
	//id가 우린 전부 Long인데, String으로 하지 않아도 될지?
	@Id
	@GeneratedValue
	@Column(name = "menu_id")
	private Long menuId;
	
	//메뉴명
	@Column(name = "menu_nm")
	private String menuNm;
	//메뉴코드
	@Column(name = "menu_code")
	private String menuCode;
	
	//매장 : 메뉴 = 1:n ?
	//메뉴 카테고리가 매장과 1:n이면 메뉴 : 카테고리 = 1:n인데, 매장을 menubase에서 매핑이 필요?
	@Embedded	// 컬럼을 하나의 객체로 사용하기 // 필수 ?
	@ManyToOne(fetch = LAZY)	// 단방향 ?
    @JoinColumn(name = "store_id")
    private Store store;
	
	//판매상태
	@Enumerated(EnumType.STRING)
    private MenuStatus menuStatus;
	//판매가(정가)
	private int price;
	
	//메뉴그룹ID
	@Embedded	// 컬럼을 하나의 객체로 사용하기
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "menu_grp_id")
	private MenuGroup menugroup;
	
	//매핑이 전부다 필요할 것 같아서 추가
	//메뉴 조회시 옵션, 이미지, 재고 전부 가져와야하지 않을까?
	//옵션그룹 매핑? 메뉴:옵션그룹 = 1:n ?
	@OneToMany(mappedBy = "opt_grp_id")
	private List<OptionGroup> optionGroupList;
	//재고 매핑? 1:1 ?
	@OneToOne(fetch = LAZY, cascade = Cascade)
	private Inventory inventory;
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
	
	//태그뱃지 - 태그 개수 여러개? 일 경우? 
	@Column(name = "tag_badge")
	private String tagBadge;
	//사용여부
	@Column(name = "use_yn")
	private String useYn;
	//삭제여부 - tinytext?
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
