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
public class StoreCategoryMapping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_category_mapping_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public StoreCategoryMapping(Long id, Store store, Category category) {
        this.id = id;
        this.store = store;
        this.category = category;
    }
}
