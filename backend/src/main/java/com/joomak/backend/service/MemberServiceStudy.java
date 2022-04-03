//package com.joomak.backend.service;
//
//import com.joomak.backend.domain.member.entity.Member;
//import com.joomak.backend.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * MemberService에 UserDetailsService를 구현할지 새로운 service를 만들어 구현할지 결정.
// */
//@Service
//@RequiredArgsConstructor
//public class MemberService implements UserDetailsService {
//
//    private final MemberRepository members;
//
//    @Override
//    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//        Member member = members.findByLoginId(loginId)
//                .orElseThrow(() -> new UsernameNotFoundException("로그인 실패했습니다.")); //todo ErrorMessage에 메세지 추가.\
//
//        return new User(loginId, member.getPassword(), new SimpleGrantedAuthority())
//
//        return member;
//    }
//}
