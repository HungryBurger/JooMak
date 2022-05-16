package com.joomak.backend.model.member.entity;

import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.common.YorN;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StoreImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="store_id")
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
