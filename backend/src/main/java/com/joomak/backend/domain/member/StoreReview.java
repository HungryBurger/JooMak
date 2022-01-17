package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.YorN;
import com.joomak.backend.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class StoreReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storeReviewId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="storeId")
    private Store store;

    private String comment;

    @Enumerated(STRING)
    private YorN deleteYn;

    private LocalDateTime deleteAt;

    private YorN secretYn;

    @ManyToOne
    @JoinColumn(name = "orderNo")
    private Order orderNo;


}
