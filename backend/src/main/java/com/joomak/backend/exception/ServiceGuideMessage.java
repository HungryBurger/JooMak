package com.joomak.backend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;

@Getter
@RequiredArgsConstructor
public enum ServiceGuideMessage {

    NOT_EXIST_MEMBER(LogLevel.INFO, "해당 계정이 존재하지 않습니다" ),
    INVALID_PASSWORD(LogLevel.INFO, "비밀번호가 틀렸습니다" ),

    REQUEST_SUCCESS(LogLevel.INFO, "요청이 성공했습니댜"),

    INVALID_MEMBER_TYPE(LogLevel.ERROR, "유저 타입이 유효하지 않습니다"),
    INVALID_EMAIL_PATTERN(LogLevel.ERROR, "올바른 이메일을 입력해주세요"),

    USER_NOT_FOUND(LogLevel.ERROR, "존재하지 않은 유저입니다"),
    ALREADY_EXIST_MEMBER(LogLevel.ERROR, "이미 가입된 이메일입니다"),
    INVALID_LOGIN_INFO(LogLevel.ERROR, "아이디와 비밀번호를 확인해주세요"),

    REQUIRED_LOGIN(LogLevel.ERROR, "로그인이 필요합니다"),
    ;

    private final LogLevel logLevel;
    private final String userGuideMessage;
}