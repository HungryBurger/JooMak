package com.joomak.backend.controller;


import com.joomak.backend.domain.member.Member;
import com.joomak.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/members/{memberId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Member> getMembers(@PathVariable("memberId") Long memberId) {
        Member member = memberService.findById(memberId);
        return ResponseEntity.ok(member);
    }
    /**
     * HttpServletRequest가 아닌 Custom object를 파라미터로 받을것.
     */
    @PostMapping(value = "/member")
    public ResponseEntity<Member> save(Member member) {
        return ResponseEntity.ok(memberService.save(member));
    }
}
