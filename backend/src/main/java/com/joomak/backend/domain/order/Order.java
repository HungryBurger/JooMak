package com.joomak.backend.domain.order;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.OrderStatus;
import com.joomak.backend.domain.member.Member;
import com.joomak.backend.domain.member.Product;
import com.joomak.backend.domain.member.Rider;
import com.joomak.backend.domain.member.Store;
import com.joomak.backend.domain.product.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@Table(name = "Orders")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @OneToOne(mappedBy = "order")
    private Review review;

    @OneToMany(mappedBy = "order")
    private List<Product> product;

    @Enumerated
    private OrderStatus orderStatus;

    private LocalDateTime orderCompleteAt;

    private LocalDateTime orderCancelAt;

    private LocalDateTime orderDeliverAt;

    private LocalDateTime orderDeliverCompleteAt;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @OneToOne
    @JoinColumn(name="riderId")
    private Rider rider;


}
