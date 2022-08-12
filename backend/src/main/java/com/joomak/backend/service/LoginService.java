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

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;
    private final UserRepository memberRepository;

    public User login(User user) {
        User saved = Optional.ofNullable(memberService.findByEmail(user.getEmail()))
                .orElseThrow(() -> new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.NOT_EXIST_MEMBER));

        if (checkIdPassword(user, saved)) {
            return saved;
        } else {
            throw new ServiceGuideException(HttpStatus.BAD_REQUEST, ServiceGuideMessage.INVALID_PASSWORD);
        }
    }

    public static boolean checkIdPassword(User loginUser, User savedUser) {
        return loginUser.getPassword().equals(savedUser.getPassword());
    }
}
