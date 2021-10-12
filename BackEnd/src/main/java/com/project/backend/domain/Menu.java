
@Entity
@Getter
@Setter
@Table
public class Menu {
	@Id
	@GeneratedValue
	@Column(name = "menu_id")
	private int menuId;
	
	//메뉴명
	private String menuNm;
	//메뉴코드
	private String menuCode;
	//점주ID
	private int ownerid;
	
	//판매상태
	private String menuStat;
	//판매가(정가)
	private int price;
	
	//메뉴그룹ID
	private MenuGroup menugroup;
	//메뉴구성
	//메뉴설명
	//주문안내문구
	//대표메뉴여부
	//옵션사용여부
	//최소주문수량
	//최대주문수량
	//원산지
	//태그뱃지
	//사용여부
	//삭제여부
	//등록자
	private int sysRegId;
	//등록일
	private LocalDateTime sysRegAt;
	//수정자
	private int sysUpdId;
	//수정일
	private LocalDateTime sysUpdAt;
	
}
