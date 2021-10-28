package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "Member")
public class Member {

    //회원 번호
    @Id @GeneratedValue
    @Column(name = "mbr_id")
    private Long id;

    //회원 이름
    @Column(name = "mbr_nm")
    private String name;

    //회원 상태(휴면,진상,일반)
    @Column(name = "mbr_stat_cd")
    private int status;

    //로그인 id
    private String loginId;

    //sns로그인 여부
    @Column(name= "sns_login_yn")
    private char snsLogin;

    //생년월일
    private String birth;

    //성별
    private String gender;

    //이메일
    private String email;

    //휴대폰번호
    private String mobile;

    //비밀번호
    private String password;

    //가입일
    private int joinedAt;

    //마지막 로그인 날짜
    private int loginedAt;

    //로그인 실패 횟수
    private int loginFailedCnt;

    //마지막 비밀번호 변경일
    private int pwChangedAt;

    //등록자
    private int sysRegId;

    //등록일
    private int sysRegAt;

    //수정자
    private int sysUpdId;

    //수정일
    private int sysUpdAt;

    //프로필이미지
    private String mbrProfileImgPath;

    //닉네임
    private String nickname;
//
//    // OneToMany mappedyBy의 개념이 명확하지 않습니다. 13일 질문 필요함.
//    // 다른 클래스들 참고 및 구글링 통해 내가이해한 개념 : mappedBy로 선언된 테이블은 주인임.(참조될 데이터를 다른테이블에 전해주는 쪽)
//    //ex) 하나의 회원은 여러개의 주소를 가지기때문에 회원이 주인임. mappedBy = "etc" etc안에 들어가는 내용은 단순히
//    // 별칭을 지정해주는것?
    //회원주소 맵핑
    @OneToMany(mappedBy = "mbrId")
    List<MemberAddress> memberAddresses = new ArrayList<>();

    //회원등급 맵핑
    @OneToOne(mappedBy = "mbrId")
    private MemberGrade memberGrade;

    //sns 로그인 맵핑
    @OneToOne(mappedBy = "mbrId")
    private Provider provider;

    @OneToOne(mappedBy = "mbrId")
    private MemberDormant dormant;

    @OneToOne(mappedBy = "mbrId")
    private MemberBanned banned;

    @OneToOne(mappedBy = "mbrId")
    private MemberRequirement requirement;
//
//    //맛객일지와 관계를 맺는 맵핑 부분인데, 해당 맛객일지 부분은 송이님 파트라 일단 주석처리.
//    @OneToMany(mappedBy = "member")
//    List<MgList> mgLists = new ArrayList<>();



//    @OneToMany(mappedBy = "member") //읽기 전용이된다.
//    private List<Order> orders = new ArrayList<>();



}
