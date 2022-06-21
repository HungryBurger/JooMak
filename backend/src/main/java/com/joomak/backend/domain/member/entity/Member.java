package com.joomak.backend.domain.member.entity;


import com.joomak.backend.domain.common.*;
import com.joomak.backend.domain.member.enums.Gender;
import com.joomak.backend.domain.member.enums.Grade;
import com.joomak.backend.domain.member.enums.MemberState;
import com.joomak.backend.domain.member.enums.RoleType;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

/**
 * UserDetails를 Entity에서 구현할지 새로운 DTO를 만들어 구현할 지 결정.
 */
@Entity
@Getter
@ToString
@NoArgsConstructor(access = PROTECTED)
//implements UserDetails
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_state", nullable = false)
    @Enumerated(STRING)
    private MemberState memberState; //normal, standby ,banned, secession, dormant

    @Column(nullable = false)
    @Enumerated(STRING)
    private Grade grade; //bronze, silver, gold, platinum, diamond

    @Column(name = "nick_name", nullable = false, unique = true)
    private String nickName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;  //USER, OWNER, ADMINISTRATOR

    @Column(name = "sns_login_yn", nullable = false)
    private Boolean snsLoginYn;

//    @Column(nullable = false)
//    private LocalDateTime birth;
    //Login ID 겸용

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Gender gender; //male female;

    @Column(name = "profile_image_path")
    private String profileImagePath;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false, unique = true)
    private String uid;

    @Column(name = "banned_yn", nullable = false)
    private Boolean bannedYn = false;

    @Column(nullable = false)
    private String password;

    @Column(name = "login_fail_count", nullable = false)
    private Integer loginFailCount = 0;

//    private TokenEntity tokenEntity;

    public Member updateNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Member updateMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Member updateBanned(Boolean yn){
        this.bannedYn = yn;
        return this;
    }

    @Builder
    public Member(String memberName, MemberState memberState, Grade grade, String nickName, Role role, Boolean snsLoginYn, LocalDateTime birth, String email, Gender gender, String profileImagePath, String mobile, String uid, Boolean bannedYn, String password, Integer loginFailCount) {
        this.memberName = memberName;
        this.memberState = memberState;
        this.grade = grade;
        this.nickName = nickName;
        this.role = role;
        this.snsLoginYn = snsLoginYn;
//        this.birth = birth;
        this.email = email;
        this.gender = gender;
        this.profileImagePath = profileImagePath;
        this.mobile = mobile;
        this.uid = uid;
        this.bannedYn = bannedYn;
        this.password = password;
        this.loginFailCount = loginFailCount;
    }
}
