package com.joomak.backend.model.member.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name ="product_id")
    private List<Product> products;



}
