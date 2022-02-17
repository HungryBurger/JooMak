package com.joomak.backend.domain.order;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.member.Member;
import com.joomak.backend.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@Table(name = "Orders")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cartId")
    private Long id;

    @OneToOne
    @JoinColumn(name ="memberId")
    private Member member;

    @OneToMany
    @JoinColumn(name ="menuId")
    private List<Product> products;

}
