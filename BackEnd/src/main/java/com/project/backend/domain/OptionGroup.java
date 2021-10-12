

@Entity
@Getter
@Setter
@Table
public class OptionGroup {
	
	@Id
	@GeneratedValue
	@Column(name = "opt_grp_id")
	private int optGrpId;
	
	@ManyToOne(fatch = LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	//옵션그룹명
	private String optGrpNm;
	
	//사용여부
	private String useYn;
	//삭제여부
	private String delYn;
	
	//옵션필수여부
	private String optReqYn;
	//옵션그룹순서
	private int optGrpSrt;
	
	//등록자
	private int sysRegId;
	//등록일
	private LocalDateTime sysRegAt;
	//수정자
	private int sysUpdId;
	//수정일
	private LocalDateTime sysUpdAt;
	
}
