package com.joomak.backend.domain.product;

import com.joomak.backend.domain.common.MenuTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

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
