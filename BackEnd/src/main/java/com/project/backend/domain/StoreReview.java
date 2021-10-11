package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class StoreReview {

    @Id @GeneratedValue
    @Column(name = "review_id")
    // 리뷰 ID
    private Long id;

    @Embedded
    @ManyToOne
    @JoinColumn(name = "store_id")  // 외래키
    private Store store;

    @OneToOne
    @JoinColumn(name = "ord_id")    // 외래키
    private Order order;

    // 댓글
    private String comment;

    @Column(name = "writer_gb")
    // 작성자 구분
    private String writerGb;

    @Column(name = "writer_at")
    // 작성일시
    private String writerAt;

    @Column(name = "edit_at")
    // 수정일시
    private String editAt;

    @Column(name = "delete_yn")
    // 삭제 여부
    private String deleteYn;

    @Column(name = "delete_at")
    // 삭제 일시
    private String deleteAt;

    @Column(name = "secret_yn")
    // 비밀 여부
    private String secretYn;

    @Column(name = "writer")
    // 작성자
    private int writer;

}