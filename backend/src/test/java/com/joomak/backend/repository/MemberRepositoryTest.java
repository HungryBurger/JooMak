package com.joomak.backend.repository;

import com.joomak.backend.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private MemberRepository memberRepository;

    private Member testMember1 = new Member();

    @Test
    void test() {
        Member saved1 = memberRepository.save(testMember1);
        assertThat(testMember1).isEqualTo(saved1);

        saved1.updateNickName("test2");
        Member saved2 = memberRepository.save(saved1);
        assertThat(saved1).isEqualTo(saved2);
    }
}