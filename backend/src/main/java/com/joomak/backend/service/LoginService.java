package com.joomak.backend.service;

import com.joomak.backend.model.member.entity.Member;
import com.joomak.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public Member login(Member member) {
        return null;
    }

    public static boolean checkIdPassword(Member loginUser, Member savedUser) {
        return false;
    }
}
