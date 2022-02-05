package com.joomak.backend.domain.product;

import com.joomak.backend.domain.common.MenuTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "productId")
    private Long id;

    private String productName;

    @Enumerated
    private MenuTypes types;

    private int stockCount;

    private int safetyStockCount;
}
