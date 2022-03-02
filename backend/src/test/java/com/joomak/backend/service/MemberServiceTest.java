package com.joomak.backend.service;

import com.joomak.backend.domain.member.Member;
import com.joomak.backend.domain.common.MemberState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("맴버 저장 테스트")
    @Transactional
    void memberSaveTest() {
        String nickName = "hello";
        Member member = Member.builder()
                .nickName(nickName)
                .bannedYn(true)
                .snsLoginYn(false)
                .birth(LocalDateTime.now())
                .email("hjjooave@naver.com")
                .memberName("형진")
                .memberState(MemberState.NORMAL)
                .build();

        Member saved = memberService.save(member);

        assertThat(saved.getNickName()).isEqualTo(nickName);
        assertThat(saved.getBannedYn()).isTrue();
        assertThat(saved.getSnsLoginYn()).isFalse();

    }
    
}