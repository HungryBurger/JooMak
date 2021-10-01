package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Table
public class PayBase {

    @Id
    @GeneratedValue
    @Column(name = "pay_id")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderBase order; //배송정보

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "mbr_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private PayStatus payStatus; // 결제 상태

    @Enumerated(EnumType.STRING)
    private PayType payType; // 결제 종륲
    // 응답 상태
    private String code;
    // 응답 상세 코드
    private String method_result_code;
    // 응답 상세 메세지
    private String method_result_message;
    // 요청 고유 번호
    private String aid;
    // 결제 고유 번호
    private String tid;
    // 가맹점 코드
    private String cid;
    // 가맹점 주문번호
    private String partner_order_id;
    // 가맹전 회원 id
    private String partner_user_id;
    // 결제 수단
    private String payment_method_type;
    // 상품 이름
    private String item_name; // item 이라 해야 할 지 ,, menu라 해야 할지
    // 상품 수량
    private String amount;
    // 카드 타입
    private String card_type;
    // 카드사 가맹점 번호
    private String card_mid;
    // 매입 카드사 코드
    private String purchase_corp_code;
    // 카드 발급사 코드
    private String issuer_corp_code;
    // 결제 준비 요청 시각
    private String created_at;
    // 결제 승인 시각
    private String approved_at;

    //등록일
    private LocalDateTime sysRegAt;
    //등록자
    private LocalDateTime sysRegId;
    //수정일
    private LocalDateTime sysUpdAt;
    //수정자
    private LocalDateTime sysUpdId;
}
