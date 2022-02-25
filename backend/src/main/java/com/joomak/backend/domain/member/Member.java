package com.joomak.backend.domain.member;


import com.joomak.backend.domain.common.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PACKAGE;

/**
 * UserDetails를 Entity에서 구현할지 새로운 DTO를 만들어 구현할 지 결정.
 */
@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
//implements UserDetails
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    private String memberName;

    @Enumerated(STRING)
    private MemberState memberState; //normal, standby ,banned, secession, dormant

    @Enumerated(STRING)
    private Grade grade; //bronze, silver, gold, platinum, diamond

    private String loginId;
    private String nickName;

    @Enumerated(STRING)
    private Role role;  //USER, OWNER, ADMINISTRATOR

    private Boolean snsLoginYn;

    private LocalDateTime birth;

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
