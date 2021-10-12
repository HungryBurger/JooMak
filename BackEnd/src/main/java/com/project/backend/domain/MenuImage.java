
public class MenuImage {
	
	@Id
	@GeneratedValue
	@Column(name = "menu_img_id")
	private int menuImgId;
	
	//이미지 : 메뉴 = 1:1 ?
	@OneToOne(fetch = LAZY, cascade = Cascade)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	//이미지순서
	private int imgSrt;
	//원본이미지명
	private String orgImgNm;
	//저장이미지명
	private String dirImgNm;
	//저장경로
	private String imgPath;
	
	//삭제여부
	private string delYn;
	
	//등록자
	private int sysRegId;
	//등록일
	private LocalDateTime sysRegAt;
	//수정자
	private int sysUpdId;
	//수정일
	private LocalDateTime sysUpdAt;
}
