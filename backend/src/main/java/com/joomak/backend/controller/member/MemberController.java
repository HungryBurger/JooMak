package com.joomak.backend.controller.member;


import com.joomak.backend.model.member.dto.MemberCreateRequest;
import com.joomak.backend.model.member.dto.MemberCreateResponse;
import com.joomak.backend.model.member.entity.Member;
import com.joomak.backend.service.LoginService;
import com.joomak.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final LoginService loginService;
    // 회원번호로 한명의 회원 조회
    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{member-id}")
    public ResponseEntity<Member> getMembers(@PathVariable(value = "member-id") Long memberId) {
        Member member = memberService.getMember(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // 모든 회원 조회
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> member = memberService.getAllMembers();
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    // 회원 저장
    @PostMapping
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        log.info("회원 가입 정보 = {}", memberCreateRequest);
        //원초적인건 Entity를 반환(Custom한 Dto 형태로 하면 재사용성이 없어지기 때문)
        //먼가 세부적인 경우는 Dto 형태로 변환해서 전달해주면 될 듯
        MemberCreateResponse memberCreateResponse = memberService.createMember(memberCreateRequest);
        return new ResponseEntity<>(memberCreateResponse, HttpStatus.OK);
    }
    // 로그인
    @PostMapping(value="/login")
    public ResponseEntity<Member> login(Member member){
        return ResponseEntity.ok(loginService.login(member));
    }
}
