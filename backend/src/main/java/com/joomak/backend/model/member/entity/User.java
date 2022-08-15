package com.joomak.backend.model.member.entity;


import com.joomak.backend.model.common.*;
import com.joomak.backend.model.member.enums.Gender;
import com.joomak.backend.model.member.enums.Grade;
import com.joomak.backend.model.member.enums.MemberState;
import com.joomak.backend.model.member.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

/**
 * Email ID가 로그인 ID
 */
@Entity
@Getter
@ToString
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String memberName;

    @ElementCollection
    @CollectionTable(name="delivery_address", joinColumns = @JoinColumn(name= "member_id"))
    private List<Address> deliveryAddressList;

    @Enumerated(STRING)
    private MemberState memberState; //normal, standby ,banned, secession, dormant

    @Enumerated(STRING)
    private Grade memberGrade; //bronze, silver, gold, platinum, diamond

    @Enumerated(STRING)
    private Role memberRole;  //USER, OWNER, ADMINISTRATOR
    private LocalDateTime birth;

    @Enumerated(STRING)
    private Gender gender;

    private String email;

    private String profileImagePath;

    private String mobile;

    private String password;

    private LocalDateTime lastLoginedAt;

    private LocalDateTime loginFailCount;

    public void setLastLoginedAt(LocalDateTime lastLoginedAt) {
        this.lastLoginedAt = lastLoginedAt;
    }

    public void setMemberGrade(Grade memberGrade) {
        this.memberGrade = memberGrade;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMemberState(MemberState memberState) {
        this.memberState = memberState;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLoginFailCount(LocalDateTime loginFailCount) {
        this.loginFailCount = loginFailCount;
    }

    @Builder
    public User(Long id, String memberName, List<Address> deliveryAddressList, MemberState memberState, Grade memberGrade, Role memberRole, LocalDateTime birth, Gender gender, String email, String profileImagePath, String mobile, String password, LocalDateTime lastLoginedAt, LocalDateTime loginFailCount) {
        this.id = id;
        this.memberName = memberName;
        this.deliveryAddressList = deliveryAddressList;
        this.memberState = memberState;
        this.memberGrade = memberGrade;
        this.memberRole = memberRole;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.profileImagePath = profileImagePath;
        this.mobile = mobile;
        this.password = password;
        this.lastLoginedAt = lastLoginedAt;
        this.loginFailCount = loginFailCount;
    }
}
