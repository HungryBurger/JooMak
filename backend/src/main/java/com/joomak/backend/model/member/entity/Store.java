package com.joomak.backend.model.member.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.member.enums.Grade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = PROTECTED)
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String storeName;

    private String storeState;

    private double storeGrade;

    private int pickCount;

    private LocalDateTime birth; //창업일

    private LocalDateTime businessStartHour;

    private LocalDateTime businessEndHour;

    private String email;

    private String mobile;

    private String storeMainComment;

    private String storeSubComment;

    private int averageDeliverTime;  //평균 배달 시간(분단위)

    private String storeImagePath;
}
