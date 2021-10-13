package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity		// JPA
@Getter
@Setter
@Table
public class Inventory {
	
	///inventory -> Stock?
	
	@Id
	@GeneratedValue
	@Column(name = "inventory_id")
	private Long inventoryId;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "menu_id")
	private MenuBase menubase;
	
	//재고수량
	@Column(name = "inventory_quantity")
	private int inventoryQuantity;
	//안전재고
	@Column(name = "safety_inventory")
	private int safetyInventory;
	
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
