package com.joomak.backend.domain.order;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.OrderStatus;
import com.joomak.backend.domain.member.Member;
import com.joomak.backend.domain.member.MemberDeliveryAddress;
import com.joomak.backend.domain.member.Rider;
import com.joomak.backend.domain.member.Store;
import com.joomak.backend.domain.product.Review;
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
    @Column(name="orderId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @OneToOne(mappedBy = "order")
    private Review review;

    @OneToMany(mappedBy = "order")
    private List<OrderProductMapping> orderProductMappingList;

    @OneToOne
    @JoinColumn(name="memberDeliveryAddressId")
    private MemberDeliveryAddress memberDeliveryAddress;

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

    @Builder

    public Order(Long id, Member member, Review review, List<OrderProductMapping> orderProductMappingList, MemberDeliveryAddress memberDeliveryAddress, OrderStatus orderStatus, LocalDateTime orderCompleteAt, LocalDateTime orderCancelAt, LocalDateTime orderDeliverAt, LocalDateTime orderDeliverCompleteAt, Store store, Rider rider) {
        this.id = id;
        this.member = member;
        this.review = review;
        this.orderProductMappingList = orderProductMappingList;
        this.memberDeliveryAddress = memberDeliveryAddress;
        this.orderStatus = orderStatus;
        this.orderCompleteAt = orderCompleteAt;
        this.orderCancelAt = orderCancelAt;
        this.orderDeliverAt = orderDeliverAt;
        this.orderDeliverCompleteAt = orderDeliverCompleteAt;
        this.store = store;
        this.rider = rider;
    }
}
