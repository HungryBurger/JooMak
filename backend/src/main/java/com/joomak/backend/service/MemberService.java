package com.joomak.backend.service;

import com.joomak.backend.model.member.entity.User;
import com.joomak.backend.exception.ServiceGuideException;
import com.joomak.backend.exception.ServiceGuideMessage;
import com.joomak.backend.repository.UserRepository;
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
    private final UserRepository memberRepository;

    public List<User> findAll() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public User findById(Long mbrId) {
        return memberRepository.findById(mbrId).orElse(null);
    }

    public User findByEmail(String email) {
        return memberRepository.findByEmail(email).orElse(null);
    }

    @Transactional
    public User save(User user) {
        log.info("It will be Saved Member = {}", user);
        User saved = memberRepository.save(user);
        log.info("Saved Member = {}", saved);
        return saved;
    }

    @Transactional
    public User ban(Long memberId) {
        User user = memberRepository.findById(memberId).orElseThrow(() -> new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.NOT_EXIST_MEMBER));
        log.info("Member ban = {}", user);
        memberRepository.save(user);
        return user;
    }


    //    public void checkDuplicateEmail(String email) {
//        memberRepository.findByEmail(email)
//        .ifPresent((member) -> {
//            throw new RuntimeException(member.getEmail() + ALREADY_EXISTS_MEMBER.getErrorMessage());
//        });
//    }

}
