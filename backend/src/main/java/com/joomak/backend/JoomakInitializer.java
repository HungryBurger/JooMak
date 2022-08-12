package com.joomak.backend;

import com.joomak.backend.model.member.entity.User;
import com.joomak.backend.model.member.enums.MemberState;
import com.joomak.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoomakInitializer implements ApplicationRunner {

    private final UserRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) {
        for (int idx = 0; idx < 10; ++idx) {
            memberRepository.save(createMember(idx));
        }
    }

    private User createMember(int idx) {
        return User.builder()
                .memberName("memberName" + idx)
                .memberState(idx % 2 == 0 ? MemberState.NORMAL : MemberState.STANDBY)
                .email("email" + idx + "@naver.com")
                .build();
    }
}
