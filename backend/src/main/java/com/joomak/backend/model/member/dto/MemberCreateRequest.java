package com.joomak.backend.model.member.dto;


import com.joomak.backend.model.member.entity.Address;
import com.joomak.backend.model.member.entity.Member;
import com.joomak.backend.model.member.enums.Gender;
import com.joomak.backend.model.member.enums.Grade;
import com.joomak.backend.model.member.enums.MemberState;
import com.joomak.backend.model.member.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor
public class MemberCreateRequest {

    private String name;

    private String password;

    private List<AddressInfo> addressCreateInfoList;

    private MemberState state; //normal, standby ,banned, secession, dormant

    private Grade grade; //bronze, silver, gold, platinum, diamond

    private String nickname;

    private Role role;  //USER, OWNER, ADMINISTRATOR

    private Boolean snsLoginYn; //boolean 기본형 일때 null이라면 error //Entity 일때는 참조형인 Boolean을 사용한다.

    private LocalDate birth;

    private String email;

    private Gender gender; //male female;

    private String profileImagePath;

    private String mobile;

    private Integer loginFailCount;

    private LocalDateTime lastLoginedAt;


    public MemberCreateRequest(String name, String password, List<AddressInfo> addressCreateInfoList, MemberState state, Grade grade, String nickname, Role role, Boolean snsLoginYn, LocalDate birth, String email, Gender gender, String profileImagePath, String mobile, Integer loginFailCount, LocalDateTime lastLoginedAt) {
        this.name = name;
        this.password = password;
        this.addressCreateInfoList = addressCreateInfoList;
        this.state = state;
        this.grade = grade;
        this.nickname = nickname;
        this.role = role;
        this.snsLoginYn = snsLoginYn;
        this.birth = birth;
        this.email = email;
        this.gender = gender;
        this.profileImagePath = profileImagePath;
        this.mobile = mobile;
        this.loginFailCount = loginFailCount;
        this.lastLoginedAt = lastLoginedAt;
    }

    @Builder


    public Member DtoToEntity(MemberCreateRequest memberCreateRequest) {
        Member member = Member.builder()
                .state(MemberState.NORMAL)
                .birth(memberCreateRequest.getBirth())
                .email(memberCreateRequest.getEmail())
                .gender(memberCreateRequest.getGender())
                .grade(Grade.SILVER)
                .loginFailCount(0)
                .mobile(memberCreateRequest.getMobile())
                .name(memberCreateRequest.getName())
                .password(memberCreateRequest.getPassword())
                .role(Role.USER)
                .profileImagePath(memberCreateRequest.getProfileImagePath())
                .lastLoginedAt(LocalDateTime.now())
                .build();

        List<Address> addressList = new ArrayList<>();
        for (AddressInfo addressInfo : memberCreateRequest.getAddressCreateInfoList()) {
            Address address = Address.builder()
                    .city(addressInfo.getCity())
                    .isMainDeliveryAddress(addressInfo.isMainDeliveryAddress())
                    .street(addressInfo.getStreet())
                    .postCode(addressInfo.getPostCode())
                    .build();
            addressList.add(address);
        }

        member.setDeliveryAddressList(addressList);

        return member;
    }
}