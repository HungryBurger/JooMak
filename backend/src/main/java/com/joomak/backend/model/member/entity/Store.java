package com.joomak.backend.model.member.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.member.enums.Grade;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name="address", joinColumns = @JoinColumn(name= "member_id"))
    private List<Address> addressList;

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

    @Builder
    public Store(Long id, User user, List<Address> addressList, String storeName, String storeState, double storeGrade, int pickCount, LocalDateTime birth, LocalDateTime businessStartHour, LocalDateTime businessEndHour, String email, String mobile, String storeMainComment, String storeSubComment, int averageDeliverTime, String storeImagePath) {
        this.id = id;
        this.user = user;
        this.addressList = addressList;
        this.storeName = storeName;
        this.storeState = storeState;
        this.storeGrade = storeGrade;
        this.pickCount = pickCount;
        this.birth = birth;
        this.businessStartHour = businessStartHour;
        this.businessEndHour = businessEndHour;
        this.email = email;
        this.mobile = mobile;
        this.storeMainComment = storeMainComment;
        this.storeSubComment = storeSubComment;
        this.averageDeliverTime = averageDeliverTime;
        this.storeImagePath = storeImagePath;
    }
}
