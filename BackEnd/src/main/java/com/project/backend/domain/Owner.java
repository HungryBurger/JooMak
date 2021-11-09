package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Owner {

    @Id @GeneratedValue
    @Column(name = "owner_id")
    // 점주 ID
    private Long id;

    @Column(name = "owner_nm")
    // 점주 이름
    private String ownerNm;

    @Column(name = "login_id")
    // 로그인 ID
    private String loginId;

    // 생년월일
    private String birth;

    // 성별
    private String gender;

    // 이메일
    private String email;

    // 휴대폰 번호
    private String mobile;

    // 비밀번호
    private String password;

    @Column(name = "joined_at")
    // 가입일
    private String joinedAt;

    @Column(name = "logged_in_at")
    // 최근 로그인 날짜
    private String loggedInAt;

    @Column(name = "login_failed_cnt")
    // 로그인 실패 횟수
    private int loginFailedCnt;

    @Column(name = "pw_changed_at")
    // 비밀번호 변경일
    private String pwChangedAt;

    @Column(name = "mbr_profile_img_path")
    // 점주 프로필 사진
    private String mbrProfileImgPath;

    @Column(name = "sys_reg_id")
    // 등록자
    private int sysRegId;

    @Column(name = "sys_reg_at")
    // 등록일
    private int sysRegAt;

    @Column(name = "sys_upd_id")
    // 수정자
    private int sysUpdId;

    @Column(name = "sys_upd_at")
    // 수정일
    private int sysUpdAt;

}