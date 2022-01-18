package com.joomak.backend.domain.product;

import com.joomak.backend.domain.common.YorN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PACKAGE)
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optionId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "optionGroupId")
    private OptionGroup optionGroup;

    private String optionName;

    private int optionPrice;

    //옵션 순서
    private int optionSequence;

    private YorN useYn;

    private YorN deleteYn;
}
