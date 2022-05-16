package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.YorN;
import com.joomak.backend.model.member.entity.Store;
import com.joomak.backend.model.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Review {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "review_id")
    private Long id;

    //한 리뷰에 대해서 하나의 주문만 가능
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String content;

    private int likeCount;

    private int dislikeCount;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private String reviewType;

    //TODO 점수일때 처리하는 방식 확인해보기
    private int reviewScore;

    private YorN deleteYn;

    private String deleteReason;
}
