package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
////////////Delete Entity?
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "inventory_quantity")
    private Integer inventoryQuantity;

    @Column(name = "safety_inventory")
    private Integer safetyInventory;

}
