package com.joomak.backend.model.product.entity;

import com.joomak.backend.model.common.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MenuBase")
@Getter
//@Builder
@EqualsAndHashCode(callSuper = false)
public class MenuBase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "menu_nm")
    private String menuNm;

    @Column(name = "menu_code")
    private String menuCode;

    @Column(name = "menu_stat")
    private String menuStat;

    @Column(name = "price")
    private Integer price;

    @Column(name = "menu_component")
    private String menuComponent;

    @Column(name = "menu_description")
    private String menuDescription;

    @Column(name = "order_information")
    private String orderInformation;

    @Column(name = "main_yn")
    private String mainYn;

    @Column(name = "opt_yn")
    private String optYn;

    @Column(name = "min_order_quantity")
    private Integer minOrderQuantity;

    @Column(name = "max_order_quantity")
    private Integer maxOrderQuantity;

    @Column(name = "sales_start_at")
    private LocalDateTime salesStartAt;

    @Column(name = "sales_end_at")
    private LocalDateTime salesEndAt;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "tag_badge")
    private String tagBadge;

    @Column(name = "use_yn")
    private String useYn;

    @Column(name = "del_yn")
    private String delYn;

}
