package com.joomak.backend.domain.member;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberDormant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberDormantId")
    private Long id;

    private LocalDateTime dormantStartDt;

    private LocalDateTime dormantEndDt;

    @Embedded
    private SystemInfo systemInfo;
}
