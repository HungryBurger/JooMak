package com.joomak.backend.model.member.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access=PROTECTED)
public class MemberResponseDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;
    private String encryptedPwd;
}
