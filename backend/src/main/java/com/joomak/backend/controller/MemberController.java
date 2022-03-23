package com.joomak.backend.controller;


import com.joomak.backend.domain.member.Member;
import com.joomak.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{memberId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Member> getMember(@PathVariable("memberId") Long memberId) {
        Member member = memberService.findById(memberId);
        return ResponseEntity.ok(member);
    }

    // 모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> member = memberService.findAll();
        return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
    }

    /**
     * HttpServletRequest가 아닌 Custom object를 파라미터로 받을것.
     */
    @PostMapping
    public ResponseEntity<Member> save(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.save(member));
    }

    // 특정 회원 밴 처리(악성유저처리)
    @PutMapping(value = "ban/{memberId}")
    public ResponseEntity<Member> ban(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.ban(memberId));
    }
    // 로그인
    @PostMapping
    public Member login(Member member){

    }
}
