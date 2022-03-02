package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.YorN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StoreImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storeImageId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="storeId")
    private Store store;

    private int displaySeq;

    private YorN displayYn;

    private String storeMainImage;

    private String storeProfileImg;


    @Builder

    public StoreImage(Long id, Store store, int displaySeq, YorN displayYn, String storeMainImage, String storeProfileImg) {
        this.id = id;
        this.store = store;
        this.displaySeq = displaySeq;
        this.displayYn = displayYn;
        this.storeMainImage = storeMainImage;
        this.storeProfileImg = storeProfileImg;
    }
}
