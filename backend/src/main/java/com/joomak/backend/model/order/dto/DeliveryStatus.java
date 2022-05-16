package com.joomak.backend.model.order.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DeliveryStatus {
    SHIPPING("배송중"),
    READY("배송준비중"),
    COMPLETE("주문 완료");

    private String name;
}

