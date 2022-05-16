package com.joomak.backend.model.order.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.order.dto.OrderStatus;
import com.joomak.backend.model.member.entity.Member;
import com.joomak.backend.model.member.entity.Address;
import com.joomak.backend.model.member.entity.Rider;
import com.joomak.backend.model.member.entity.Store;
import com.joomak.backend.model.product.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "Orders")
@NoArgsConstructor(access = PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(mappedBy = "order")
    private Review review;

    @OneToMany(mappedBy = "order")
    private List<OrderProductMapping> orderProductMappingList;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;

    @Enumerated
    private OrderStatus orderStatus;

    private LocalDateTime orderCompleteAt;

    private LocalDateTime orderCancelAt;

    private LocalDateTime orderDeliverAt;

    private LocalDateTime orderDeliverCompleteAt;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne
    @JoinColumn(name="rider_id")
    private Rider rider;

    @Builder

    public Order(Long id, Member member, Review review, List<OrderProductMapping> orderProductMappingList, Address address, OrderStatus orderStatus, LocalDateTime orderCompleteAt, LocalDateTime orderCancelAt, LocalDateTime orderDeliverAt, LocalDateTime orderDeliverCompleteAt, Store store, Rider rider) {
        this.id = id;
        this.member = member;
        this.review = review;
        this.orderProductMappingList = orderProductMappingList;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderCompleteAt = orderCompleteAt;
        this.orderCancelAt = orderCancelAt;
        this.orderDeliverAt = orderDeliverAt;
        this.orderDeliverCompleteAt = orderDeliverCompleteAt;
        this.store = store;
        this.rider = rider;
    }
}
