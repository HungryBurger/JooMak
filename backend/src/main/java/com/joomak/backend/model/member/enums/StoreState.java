package com.joomak.backend.model.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreState {

    NOT_OPEN("오픈전"),
    OPEN("오픈"),
    DELETE("매장 폐쇄");

    private final String name;
}
