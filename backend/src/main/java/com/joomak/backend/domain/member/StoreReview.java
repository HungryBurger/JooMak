package com.joomak.backend.domain.member;

import com.joomak.backend.domain.common.BaseEntity;
import com.joomak.backend.domain.common.YorN;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class StoreReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeReviewId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    private String comment;

    @Enumerated(STRING)
    private YorN deleteYn;

    private LocalDateTime deleteAt;

    private YorN secretYn;

    @Builder
    public StoreReview(Long id, Store store, String comment, YorN deleteYn, LocalDateTime deleteAt, YorN secretYn) {
        this.id = id;
        this.store = store;
        this.comment = comment;
        this.deleteYn = deleteYn;
        this.deleteAt = deleteAt;
        this.secretYn = secretYn;
    }
}
