package com.joomak.backend.model.member.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailType {
    AUTH_NUMBER("휴대폰 인증번호"),
    JOIN("회원가입"),
    ORDER("주문"),
    ORDER_CANCEL("주문 취소");

    private String name;
}
