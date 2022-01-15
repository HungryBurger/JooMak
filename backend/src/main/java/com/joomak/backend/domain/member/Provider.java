package com.joomak.backend.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Provider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="provider_id")
    private Long id;

    private String uid;

    @OneToOne
    @JoinColumn(name="mbr_id")
    private Member member;

    private String snsType;

    private String snsName;

    private String snsEmail;

    private LocalDateTime snsBirth;

    private Gender gender;

    private int snsAge;

    @Embedded
    private SystemInfo systemInfo;
}
