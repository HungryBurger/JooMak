package com.joomak.backend.service;

import com.joomak.backend.domain.member.Member;
import com.joomak.backend.exception.ServiceGuideException;
import com.joomak.backend.exception.ServiceGuideMessage;
import com.joomak.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public Member login(Member member) {
        Member saved = Optional.ofNullable(memberService.findById(member.getId()))
                .orElseThrow(() -> new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.NOT_EXIST_MEMBER));
        return saved;
    }

    public static boolean checkIdPassword(Member member) {
        return true;
    }
}
