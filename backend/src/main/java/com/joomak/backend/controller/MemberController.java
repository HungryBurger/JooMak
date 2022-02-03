package com.joomak.backend.controller;


import com.joomak.backend.domain.member.Member;
import com.joomak.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{memberId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Member> getMember(@PathVariable("memberId") Long memberId) {
        Optional<Member> member = memberService.findById(memberId);
        return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveMember", method = RequestMethod.GET)
    public ResponseEntity<Member> save(HttpServletRequest req, Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }
}
