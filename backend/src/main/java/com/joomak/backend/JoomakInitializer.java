package com.joomak.backend;

import com.joomak.backend.domain.member.entity.Member;
import com.joomak.backend.domain.member.enums.MemberState;
import com.joomak.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoomakInitializer implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int idx = 0; idx < 10; ++idx) {
          //  memberRepository.save(createMember(idx));
        }
    }

    private Member createMember(int idx) {
        return Member.builder()
                .nickName("nicName" + idx)
                .memberName("memberName" + idx)
                .memberState(idx % 2 == 0 ? MemberState.NORMAL : MemberState.STANDBY)
                .email("email" + idx + "@naver.com")
                .build();
    }
}
