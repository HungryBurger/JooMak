package com.joomak.backend.service;

import com.joomak.backend.model.member.entity.Member;
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
        Member saved = Optional.ofNullable(memberService.findByEmail(member.getEmail()))
                .orElseThrow(() -> new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.NOT_EXIST_MEMBER));

        if (checkIdPassword(member, saved)) {
            return saved;
        } else {
            throw new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.INVALID_PASSWORD);
        }
    }

    public static boolean checkIdPassword(Member loginMember, Member savedMember) {
        return loginMember.getPassword().equals(savedMember.getPassword());
    }
}
