package com.joomak.backend.model.product.entity;


import com.joomak.backend.model.common.YorN;
import com.joomak.backend.model.member.entity.Store;
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
public class OptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_group_id")
    private Long id;

    /**
     * 왜냐하면 하나의 메뉴에 여러개의 옵션 그룹이 있을 수 있다.'
     * 맛, 크기 등등을 고려할 수 있기 때문이다.
     */
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Product product;

    //옵션 그룹명
    private String optionGroupName;

    //사용 여부
    private YorN useYn;

    //삭제 여부
    private YorN deleteYn;

    //옵션 필수 여부
    private YorN optionRequireYn;
}
