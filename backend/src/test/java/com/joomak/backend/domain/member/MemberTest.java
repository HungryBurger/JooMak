package com.joomak.backend.domain.member;

import com.joomak.backend.util.LocalDateTimeUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class MemberTest {

    @Test
    void test() {
        LocalDateTimeUtil.convertFormat(LocalDateTime.now());
    }
}