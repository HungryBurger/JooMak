package com.joomak.backend.model.member.dto;

import com.joomak.backend.model.member.entity.Address;
import com.joomak.backend.model.member.entity.Store;
import com.joomak.backend.model.member.enums.StoreState;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class StoreRetrieveResponse {
    private Long id;

    private Long memberId;
    private Address address;

    private String storeName;

    private StoreState storeState;

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
    public StoreRetrieveResponse(Long id, Long memberId, Address address, String storeName, StoreState storeState, double storeGrade, int pickCount, LocalDateTime birth, LocalDateTime businessStartHour, LocalDateTime businessEndHour, String email, String mobile, String storeMainComment, String storeSubComment, int averageDeliverTime, String storeImagePath) {
        this.id = id;
        this.memberId = memberId;
        this.address = address;
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

    public StoreRetrieveResponse EntityToDto(Store store) {
        return StoreRetrieveResponse.builder()
                .id(store.getId())
                .memberId(store.getMember().getId())
                .address(store.getAddress())
                .averageDeliverTime(store.getAverageDeliverTime())
                .birth(store.getBirth())
                .email(store.getEmail())
                .storeName(store.getStoreName())
                .businessEndHour(store.getBusinessEndHour())
                .businessStartHour(store.getBusinessStartHour())
                .storeGrade(store.getStoreGrade())
                .storeImagePath(store.getStoreImagePath())
                .storeGrade(store.getStoreGrade())
                .storeState(store.getStoreState())
                .storeMainComment(store.getStoreMainComment())
                .storeSubComment(store.getStoreSubComment())
                .pickCount(store.getPickCount())
                .mobile(store.getMobile())
                .build();
    }
}
