package com.joomak.backend.service;

import com.joomak.backend.model.member.dto.MemberCreateRequest;
import com.joomak.backend.model.member.dto.MemberCreateResponse;
import com.joomak.backend.model.member.entity.Member;
import com.joomak.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public List<Member> getAllMembers() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public Member getMember(Long mbrId) {
        log.info("member id = {}", mbrId);
        return memberRepository.findById(mbrId).orElseThrow();
    }

    @Transactional
    public MemberCreateResponse createMember(MemberCreateRequest memberCreateRequest) {
        //DTO -> Entity
        Member member = memberCreateRequest.DtoToEntity(memberCreateRequest);

        //Member 호출
        memberRepository.save(member);

        log.info("memberId = {}",member.getId().toString());

        // Entity -> DTO
        MemberCreateResponse memberCreateResponse = new MemberCreateResponse().EntityToDto(member);

        //ID만 Return 해주면 될 것 같다
        return memberCreateResponse;
    }

}
