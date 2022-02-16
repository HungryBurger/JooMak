package com.joomak.backend.domain.member;


import com.joomak.backend.domain.common.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

/**
 * UserDetails를 Entity에서 구현할지 새로운 DTO를 만들어 구현할 지 결정.
 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
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
