package com.joomak.backend.domain.member;


import com.joomak.backend.domain.common.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

/**
 * UserDetails를 Entity에서 구현할지 새로운 DTO를 만들어 구현할 지 결정.
 */
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
//implements UserDetails
public class MemberDormant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberDormantId")
    private Long id;

    @OneToOne
    @JoinColumn(name ="memberId")
    private Member member;

    private String memberName;

    @Enumerated(STRING)
    private MemberState memberState; //normal, standby ,banned, secession, dormant

    @Enumerated(STRING)
    private Grade grade; //bronze, silver, gold, platinum, diamond

    private String loginId;

    private String nickName;

    @Enumerated(STRING)
    private Role role;  //USER, OWNER, ADMINISTRATOR

    private YorN snsLoginYn;

    private LocalDateTime birth;

    private String email;

    @Enumerated(STRING)
    private Gender gender; //male female;

    private String profileImagePath;

    private String mobile;

    private String uid;

    private YorN bannedYn;

    private String password;

    private LocalDateTime loginFailCount;

    public MemberDormant(Long id, Member member, String memberName, MemberState memberState, Grade grade, String loginId, String nickName, Role role, YorN snsLoginYn, LocalDateTime birth, String email, Gender gender, String profileImagePath, String mobile, String uid, YorN bannedYn, String password, LocalDateTime loginFailCount) {
        this.id = id;
        this.member = member;
        this.memberName = memberName;
        this.memberState = memberState;
        this.grade = grade;
        this.loginId = loginId;
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

    //
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.loginId;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

}
