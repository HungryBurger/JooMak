package com.joomak.backend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Setter
@Table
public class OrderBase {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private String id;

    //회원번호
//    @ManyToOne(fetch = FetchType.LAZY) // 굳이 member 영속성 관리 안해도 되지 않나?? 어차피 지연로딩이니깐
//    @JoinColumn(name="mbr_id")
    private Member member;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    // 라이더 요청 사항
    private String riderRequire;
    // 사장님 요청 사항
    private String ownerRequire;
    //주문 완성 시간
    private LocalDateTime orderCompleteAt;
    //주문 취소 시간
    private LocalDateTime orderCancelAt;
    //주문 배송 시작 시간
    private LocalDateTime orderDlvrStartAt;
    //주문 배송 완료 시간
    private LocalDateTime orderDlvrCompleteAt;

    //가게 정보
    //@OneToOne
    //private Store store;

    //가게 정보
    //@OneToOne
    //private Rider rider;

    @Embedded
    private Address address;

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;

    /**
     *
     *
    // 연관관계 메소드
    public void setMember(Member member) {
        this.member = member;
//      member.getOrders().add(this);
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

//    public void setRider(Rider rider) {
//        this.rider = rider;
//        rider.setOrder(this);
//    }

    //==생성 메서드==//
    public static OrderBase createOrder(Member member,
                                    OrderDetail... orderDetails) {
        OrderBase order = new OrderBase();
        order.setMember(member);
//        order.setRider(rider);
        for (OrderDetail orderDetail : orderDetails) {
            order.addOrderDetail(orderDetail);
        }
        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderCompleteAt(LocalDateTime.now());
        return order;
    }

     */

}
