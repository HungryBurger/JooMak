package com.joomak.backend.domain.member.entity;


import com.joomak.backend.domain.common.*;
import com.joomak.backend.domain.member.enums.Gender;
import com.joomak.backend.domain.member.enums.Grade;
import com.joomak.backend.domain.member.enums.MemberState;
import com.joomak.backend.domain.member.enums.Role;
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
@NoArgsConstructor(access=PROTECTED)
//implements UserDetails
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String memberName;

    @Enumerated(STRING)
    private MemberState memberState; //normal, standby ,banned, secession, dormant

    @Enumerated(STRING)
    private Grade grade; //bronze, silver, gold, platinum, diamond

    private String nickName;

    @Enumerated(STRING)
    private Role role;  //USER, OWNER, ADMINISTRATOR

    private Boolean snsLoginYn;

    private LocalDateTime birth;
    //Login ID 겸용
    private String email;

    @Enumerated(STRING)
    private Gender gender; //male female;

    private String profileImagePath;

    private String mobile;

    private String uid;

    private Boolean bannedYn;

    private String password;

    private LocalDateTime loginFailCount;

    public Member updateNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Member updateMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Member updateBanned(Boolean yn){
        this.bannedYn=yn;
        return this;
    }

    @Builder
    public Member(String memberName, MemberState memberState, Grade grade, String nickName, Role role, Boolean snsLoginYn, LocalDateTime birth, String email, Gender gender, String profileImagePath, String mobile, String uid, Boolean bannedYn, String password, LocalDateTime loginFailCount) {
        this.memberName = memberName;
        this.memberState = memberState;
        this.grade = grade;
        this.nickName = nickName;
        this.role = role;
        this.snsLoginYn = snsLoginYn;
        this.birth = birth;
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
