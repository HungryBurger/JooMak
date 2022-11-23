package com.joomak.backend.domain.member.dto;

import com.joomak.backend.domain.member.entity.Role;
import com.joomak.backend.domain.member.enums.Gender;
import com.joomak.backend.domain.member.enums.Grade;
import com.joomak.backend.domain.member.enums.MemberState;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MemberSignUpDto {
    private String memberName;
    private MemberState memberState;
    private Grade grade;
    private String nickName;
    private Role role;
    private Boolean snsLoginYn;
    private LocalDateTime birth;
    private String email;
    private Gender gender;
    private String profileImagePath;
    private String mobile;
    private String uid;
    private Boolean bannedYn;
    private String password;
    private Integer loginFailCount;

    // AccessToken 24시간
    // RefreshToken 1 년

    // GuestToken

    public MemberSignUpDto() {
        this.memberState = MemberState.NORMAL;
        this.grade = Grade.BRONZE;
        this.loginFailCount = 0;
    }

    @Builder
    public MemberSignUpDto(String memberName, MemberState memberState, Grade grade, String nickName,
        Role role, Boolean snsLoginYn, LocalDateTime birth, String email, Gender gender,
        String profileImagePath, String mobile, String uid, Boolean bannedYn, String password,
        Integer loginFailCount) {
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
