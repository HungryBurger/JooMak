package com.joomak.backend.service;

import com.joomak.backend.domain.member.dto.MemberLoginDto;
import com.joomak.backend.domain.member.entity.Member;
import com.joomak.backend.domain.member.enums.MemberState;
import com.joomak.backend.exception.ServiceGuideException;
import com.joomak.backend.exception.ServiceGuideMessage;
import com.joomak.backend.repository.MemberRepository;
import java.util.Collection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public Member findById(Long mbrId) {
        return memberRepository.findById(mbrId).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*
        Database에서 Member 정보를 받아온 후 createUser Method를 통해 UserDetails를 상속한 MemberLoginDto Class로 변환해서 반환한다.
         */
        return memberRepository.findByEmail(email)
            .map(member -> createUser(member))
            .orElseThrow(() -> new UsernameNotFoundException(email + " -> Database에서 찾을 수 없습니다."));
    }

    public UserDetails login(MemberLoginDto memberLoginDto) {
        log.info("MemberService login Method email: " + memberLoginDto.getEmail() + ", password: " + memberLoginDto.getPassword());
        return memberRepository.findByEmailAndPassword(memberLoginDto.getEmail(), memberLoginDto.getPassword())
            .map(member -> createUser(member))
            .orElseThrow(() -> new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.NOT_EXIST_MEMBER));
    }

    private MemberLoginDto createUser(Member member) {
        if (member.getMemberState() != MemberState.NORMAL) {
            throw new ServiceGuideException(HttpStatus.UNAUTHORIZED, ServiceGuideMessage.INVALID_MEMBER_TYPE);
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        log.info("authorities: " + member.getRole().getRoleName());
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getRole().getRoleName());
        authorities.add(grantedAuthority);

        return MemberLoginDto.builder()
            .email(member.getEmail())
            .password(member.getPassword())
            .roles(authorities)
            .build();
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElse(null);
    }

    public Member findByEmailAndPassword(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, password).orElse(null);
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
