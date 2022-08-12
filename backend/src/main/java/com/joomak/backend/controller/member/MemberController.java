package com.joomak.backend.controller.member;


import com.joomak.backend.model.member.entity.User;
import com.joomak.backend.service.LoginService;
import com.joomak.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    private final LoginService loginService;

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{memberId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getMember(@PathVariable("memberId") Long memberId) {
        User user = memberService.findById(memberId);
        return ResponseEntity.ok(user);
    }
    // 모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAllMembers() {
        List<User> user = memberService.findAll();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(memberService.save(user));
    }

    // 특정 회원 밴 처리(악성유저처리)
    @PutMapping(value = "/ban/{memberId}")
    public ResponseEntity<User> ban(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.ban(memberId));
    }
    // 로그인
    @PostMapping(value="/login")
    public ResponseEntity<User> login(User user){
        return ResponseEntity.ok(loginService.login(user));
    }
}
