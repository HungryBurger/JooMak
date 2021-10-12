package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table
public class Member2 {

    //회원 번호
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    //회원 이름
    @Column(name = "member_name")
    private String name;

    //회원 상태(휴면,진상,일반)
    @Column(name = "mbr_stat_cd")
    private int status;

    //로그인 id
    @Column(name= "login_id")
    private String loginId;

    //sns로그인 여부
    @Column(name= "sns_login_yn")
    private char snsLogin;

    //생년월일
    @Column(name= "birth")
    private String birth;

    //성별
    @Column(name= "gender")
    private String gender;

    //이메일
    @Column(name= "email")
    private String email;

    //휴대폰번호
    @Column(name= "mobile")
    private String mobile;

    //비밀번호
    @Column(name= "password")
    private String password;

    //가입일
    @Column(name= "joined_at")
    private int joinAt;

    //마지막 로그인 날짜
    @Column(name= "logined_at")
    private int loginAt;

    //로그인 실패 횟수
    @Column(name= "login_failed_cnt")
    private int loginFailedCnt;

    //마지막 비밀번호 변경일
    @Column(name = "pw_changed_at")
    private int pwChangedAt;

    //등록자
    @Column(name = "sys_reg_id")
    private int sysRegId;

    //등록일
    @Column(name = "sys_reg_at")
    private localDateTime sysRegAt;

    //수정자
    @Column(name = "sys_upd_id")
    private int sysUpdId;

    //수정일
    @Column(name = "sys_upd_at")
    private int sysUpdAt;

    //프로필이미지
    @Column(name = "mbr_profile_img_path")
    private String mbrProfileImgPath;

    //닉네임
    @Column(name = "nickname")
    private String nickname;

    // 아래부터는 회원 번호로 연결되는 엔티티들인데... 어떻게 연결되는것인지...?
    @Embedded
    @onetomany@ManyToOne 으로 설정.  + 패치전략
    private Address address;

    @Embedded
    private Dormant dormant;

    @Embedded
    private Banned banned;

    @Embedded
    private Provider provider;

    @Embedded
    private Grade grade;

    @Embedded
    private Mglist mglist;

    @Embedded
    private Requirements requirements;



//    @OneToMany(mappedBy = "member") //읽기 전용이된다.
//    private List<Order> orders = new ArrayList<>();

}