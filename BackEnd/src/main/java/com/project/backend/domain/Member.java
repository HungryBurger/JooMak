package com.project.backend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

//    @OneToMany(mappedBy = "member") //읽기 전용이된다.
//    private List<Order> orders = new ArrayList<>();

}
