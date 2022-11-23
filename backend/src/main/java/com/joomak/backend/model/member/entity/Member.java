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
import java.time.LocalDate;
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
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String memberName;

    @ElementCollection
    @CollectionTable(name="delivery_address", joinColumns = @JoinColumn(name= "member_id"))
    private List<Address> deliveryAddressList;

    @Enumerated(STRING)
    private MemberState state; //normal, standby ,banned, secession, dormant

    @Enumerated(STRING)
    private Grade grade; //bronze, silver, gold, platinum, diamond

    @Enumerated(STRING)
    private Role role;  //USER, OWNER, ADMINISTRATOR
    private LocalDate birth;

    private String name;

    private String nickname;

    @Enumerated(STRING)
    private Gender gender;

    private String email;

    private String profileImagePath;

    private String mobile;

    private String password;

    private LocalDateTime lastLoginedAt;

    private int loginFailCount;

    public void setLastLoginedAt(LocalDateTime lastLoginedAt) {
        this.lastLoginedAt = lastLoginedAt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLoginFailCount(int loginFailCount) {
        this.loginFailCount = loginFailCount;
    }

    @Builder
    public Member(Long id, String memberName, List<Address> deliveryAddressList, MemberState state, Grade grade, Role role, LocalDate birth, String name, Gender gender, String email, String profileImagePath, String mobile, String password, LocalDateTime lastLoginedAt, int loginFailCount) {
        this.id = id;
        this.memberName = memberName;
        this.deliveryAddressList = deliveryAddressList;
        this.state = state;
        this.grade = grade;
        this.role = role;
        this.birth = birth;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.profileImagePath = profileImagePath;
        this.mobile = mobile;
        this.password = password;
        this.lastLoginedAt = lastLoginedAt;
        this.loginFailCount = loginFailCount;
    }

    public void setDeliveryAddressList(List<Address> addressList) {
        this.deliveryAddressList = addressList;
    }
}
