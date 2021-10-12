
public class Inventory {
	
	///inventory -> Stock?
	
	@Id
	@GeneratedValue
	@Column(name = "inventory_id")
	private int inventoryId;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	//재고수량
	private int inventoryQuantity;
	//안전재고
	private int safetyInventory;
	
	//등록자
	private int sysRegId;
	//등록일
	private LocalDateTime sysRegAt;
	//수정자
	private int sysUpdId;
	//수정일
	private LocalDateTime sysUpdAt;
}
