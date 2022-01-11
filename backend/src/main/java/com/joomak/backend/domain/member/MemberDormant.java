package com.joomak.backend.domain.member;


import javax.persistence.*;

@Entity
public class MemberDormant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberDormantId")
    private Long id;
    
    @Embedded
    private SystemInfo systemInfo;

}
