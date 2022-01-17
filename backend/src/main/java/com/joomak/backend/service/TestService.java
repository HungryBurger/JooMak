package com.joomak.backend.service;

import com.joomak.backend.util.LocalDateTimeUtil;
import lombok.experimental.ExtensionMethod;
import org.springframework.stereotype.Service;

@Service
@ExtensionMethod(LocalDateTimeUtil.class)
public class TestService {

    public void test() {
//        val now = LocalDateTimeUtil.convertFormat(LocalDateTime.now());
//        var now2 = LocalDateTime.now().convertFormat();

//val var의 차이
//        val a = 1;
//        a = 2;
//
//        var b = 1;
//        b= 2;
    }
}
