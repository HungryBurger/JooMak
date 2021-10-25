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
public class Stock {
	
	@Id
	@GeneratedValue
	@Column(name = "stock_id")
	private Long id;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "menu_id")
	private MenuBase menubase;
	
	//재고수량
	@Column(name = "stock_quantity")
	private int stockQuantity;
	//안전재고
	@Column(name = "safety_stock")
	private int safetyStock;
	
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
