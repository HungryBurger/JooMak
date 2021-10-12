

public class OptionGroup {
	
	@Id
	@GeneratedValue
	@Column(name = "opt_grp_id")
	private int id;
	
	@ManyToOne(fatch = LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
}
