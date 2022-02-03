package com.joomak.backend.service;

import com.joomak.backend.domain.member.Member;
import com.joomak.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor  // final 있는 것만 constructor 생성 allargsConstructor 은
public class MemberService {
    private final MemberRepository memberRepository;


    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<Member> findById(Long mbrNo) {
        Optional<Member> member = memberRepository.findById(mbrNo);
        return member;
    }

    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }

}
