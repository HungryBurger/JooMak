
@Entity
@Getter
@Setter
@Table
public class Menu {
	
	//id가 우린 전부 int인데, String으로 하지 않아도 될지?
	@Id
	@GeneratedValue
	@Column(name = "menu_id")
	private int menuId;
	
	//메뉴명
	private String menuNm;
	//메뉴코드
	private String menuCode;
	
	//점주ID - from Owner
	//점주 : 메뉴 = 1:n ?
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	//판매상태
	private String menuStat;
	//판매가(정가)
	private int price;
	
	//메뉴그룹ID
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
	private String menuComponent;
	//메뉴설명
	private String menuDescription;
	
	//주문안내문구
	private String orderInformation;
	//대표메뉴여부
	private String mainYn;
	//옵션사용여부
	private String optYn;
	
	//최소주문수량
	private int minOrderQuantity;
	//최대주문수량
	private int maxOrderQuantity;
	//원산지
	private int country_id;
	
	//태그뱃지 - 태그 개수 여러개? 일 경우? 
	private String tagBadge;
	//사용여부
	private String useYn;
	//삭제여부 - tinytext?
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
