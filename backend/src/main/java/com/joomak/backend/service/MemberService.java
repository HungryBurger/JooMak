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

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public Member findById(Long mbrId) {
        return memberRepository.findById(mbrId).orElse(null);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElse(null);
    }

    @Transactional
    public Member save(Member member) {
        Member saved = memberRepository.save(member);
        log.info("Saved Member = {}", saved);
        return saved;
    }

    @Transactional
    public Member ban(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.NOT_EXIST_MEMBER));
        log.info("Member ban = {}", member);
        member.updateBanned(true);
        memberRepository.save(member);
        return member;
    }


    //    public void checkDuplicateEmail(String email) {
//        memberRepository.findByEmail(email)
//        .ifPresent((member) -> {
//            throw new RuntimeException(member.getEmail() + ALREADY_EXISTS_MEMBER.getErrorMessage());
//        });
//    }

}
