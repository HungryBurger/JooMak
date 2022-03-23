package com.joomak.backend.controller;

import com.joomak.backend.domain.member.Member;
import com.joomak.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class CommonController {

    private final AuthService authService;

    //인증번호 발송
    //세션값으로 어떻게 생성하는지 확인이 필요하다.
    @GetMapping(value ="/digit/{memberId}", produces={MediaType.APPLICATION_JSON_VALUE})
    public int getAuthNum(@PathVariable("memberId") Long memberId){
        int authNum = authService.getAuthNum(memberId);
        return authNum;
    }
}
