package com.joomak.backend.model.product.entity;

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
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private OptionGroup optionGroup;

    private String optionName;

    private int optionPrice;

    //옵션 순서
    private int optionSequence;

    private YorN useYn;

    private YorN deleteYn;
}
