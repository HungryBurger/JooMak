
public class MenuGroup {
	
	@Id
	@GeneratedValue
	@Column(name = "menu_grp_id")
	private int menuGrpId;
	
	//메뉴ID로 매핑해줘야하는 것 아닐지? - ERD 테이블에 없음
	//일단 추가
	@OneToMany(mappedBy = "menu_id")
	private List<Menu> menuList;

	//점주ID - from Owner
	//점주 : 메뉴 = 1:n ?
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	//메뉴그룹명
	private String menuGrpNm;
	//메뉴그룹설명
	private String menuGrpDescription;
	//메뉴그룹순서
	private int menuGrpSrt;
	//삭제여부
	private String delYn;

	//등록자
	private int sysRegId;
	//등록일
	private LocalDateTime sysRegAt;
	//수정자
	private int sysUpdId;
	//수정일
	private LocalDateTime sysUpdAt;
}
