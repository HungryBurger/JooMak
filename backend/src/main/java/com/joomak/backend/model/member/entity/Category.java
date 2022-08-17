package com.joomak.backend.model.member.entity;

import com.joomak.backend.model.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String categoryName;

    private int categorySequence;

    private String categoryImagePath;

    public Category(Long id, String categoryName, int categorySequence, String categoryImagePath) {
        this.id = id;
        this.categoryName = categoryName;
        this.categorySequence = categorySequence;
        this.categoryImagePath = categoryImagePath;
    }
}
