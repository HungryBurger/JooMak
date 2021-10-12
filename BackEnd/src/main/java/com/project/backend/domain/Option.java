
@Entity
@Getter
@Setter
@Table
public class Option {
	
	@Id
	@GeneratedValue
	@Column(name = "opt_id")
	private int id;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "opt_grp_id")
	private OptionGroup optionGroup;
	
	//옵션명
	private String optNm;
	//옵션가격
	private int optPrice;
	//옵션순서
	private int optSrt;
	
	//사용여부
	private String useYn;
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
