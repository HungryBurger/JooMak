package com.joomak.backend.domain.product;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.MenuState;
import com.joomak.backend.domain.common.YorN;
import com.joomak.backend.domain.member.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "menuId")
    private Long id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "storeId")

    private Store store;

    @Enumerated
    private MenuState menuState; // SELLING,PAUSE,OVERTIME

    private int price;

    @ManyToOne
    @JoinColumn(name = "menuGroupId")
    private MenuGroup menuGroup;

    //메뉴 구성
    @ManyToOne
    @JoinColumn(name = "productId")
    private List<Product> menuComposition;

    private String menuDescription;

    //대표 메뉴
    private YorN mainYn;

    //최대주문수량
    private int maxOrderQuantity;
    //최소주문수량
    private int minOrderQuantity;
    //옵션 사용 여부
    private YorN optionYn;

    private LocalDateTime salesStartAt;

    private LocalDateTime salesEndAt;
    //원산지
    private String countryId;

    private YorN useYn;

    private YorN deleteYn;
}
