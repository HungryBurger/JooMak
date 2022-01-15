package com.joomak.backend.domain.member;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "memberBase")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mbr_id")
    private Long id;

    @Column(name = "mbr_nm")
    private String name;

    @Column(name = "mbr_stat_cd")
    @Enumerated(EnumType.STRING)
    private MemberState memberState; //normal, standby ,banned, secession, dormant

    @Enumerated(EnumType.STRING)
    private Grade grade; //bronze, silver, gold, platinum, diamond

    @Column(name = "login_id")
    private String login_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    private String nickName;

    private char snsLoginYn;

    private LocalDateTime birth;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender; //male female;

    private String profileImagePath;

    private int mobile;

    private char bannedYn;

    private String password;

    private LocalDateTime joinedAt;

    private LocalDateTime recentLoginAt;

    private LocalDateTime loginFailCount;

    private LocalDateTime pwChangeAt;

    @Embedded
    private SystemInfo systemInfo;
}
