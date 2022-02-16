package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
public class Rider extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="riderId")
    private String id;

    private String name;

    private String phoneNumber;

    private String xPosition;

    private String yPosition;

    private String zPosition;
}
