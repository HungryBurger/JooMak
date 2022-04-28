package com.joomak.backend.model.product.entity;


import com.joomak.backend.model.common.BaseEntity;
import com.joomak.backend.model.common.YorN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class ProductImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private int imgSequence;

    private String orginImageName;

    private String imagePath;

    private YorN deleteYn;

//    @OneToMany(mappedBy = "Member")
//    private List<Attachment> attacheFiles = new ArrayList<>();
}
