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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;
@Getter
@NoArgsConstructor
public class MemberCreateResponse {
    private Long id;
    private String name;

    private String password;

    private List<AddressInfo> addressInfoList;

    private MemberState state; //normal, standby ,banned, secession, dormant

    private Grade grade; //bronze, silver, gold, platinum, diamond

    private String nickname;

    private Role role;  //USER, OWNER, ADMINISTRATOR

    private Boolean snsLoginYn; //boolean 기본형 일때 null이라면 error //Entity 일때는 참조형인 Boolean을 사용한다.

    private LocalDate birth;

    private String email;

    private String profileImagePath;

    private Gender gender; //male female;

    private String mobile;

    private Integer loginFailCount;

    private LocalDateTime lastLoginedAt;

    @Builder
    public MemberCreateResponse(Long id, String name, String password, List<AddressInfo> addressInfoList, MemberState state, Grade grade, String nickname, Role role, Boolean snsLoginYn, LocalDate birth, String email, String profileImagePath, Gender gender, String mobile, Integer loginFailCount, LocalDateTime lastLoginedAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.addressInfoList = addressInfoList;
        this.state = state;
        this.grade = grade;
        this.nickname = nickname;
        this.role = role;
        this.snsLoginYn = snsLoginYn;
        this.birth = birth;
        this.email = email;
        this.profileImagePath = profileImagePath;
        this.gender = gender;
        this.mobile = mobile;
        this.loginFailCount = loginFailCount;
        this.lastLoginedAt = lastLoginedAt;
    }

    public void setAddressInfoList(List<AddressInfo> addressInfoList) {
        this.addressInfoList = addressInfoList;
    }

    public MemberCreateResponse EntityToDto(Member member) {
        // Entity -> DTO
        MemberCreateResponse memberCreateResponse = MemberCreateResponse.builder()
                .id(member.getId())
                .state(member.getState())
                .birth(member.getBirth())
                .email(member.getEmail())
                .gender(member.getGender())
                .grade(member.getGrade())
                .loginFailCount(member.getLoginFailCount())
                .mobile(member.getMobile())
                .name(member.getName())
                .password(member.getPassword())
                .role(member.getRole())
                .nickname(member.getNickname())
                .lastLoginedAt(member.getLastLoginedAt())
                .build();

        if(member.getDeliveryAddressList().isEmpty()){
            return memberCreateResponse;
        }

        List<AddressInfo> addressList = new ArrayList<>();

        for (Address address : member.getDeliveryAddressList()) {
            AddressInfo addressInfo = AddressInfo.builder()
                    .city(address.getCity())
                    .isMainDeliveryAddress(address.isMainDeliveryAddress())
                    .street(address.getStreet())
                    .postCode(address.getPostCode())
                    .build();
            addressList.add(addressInfo);
        }

        memberCreateResponse.setAddressInfoList(addressList);
        return memberCreateResponse;
    }
}