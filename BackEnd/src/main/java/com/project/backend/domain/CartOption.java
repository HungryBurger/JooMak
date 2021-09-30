package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class CartOption {
    @Id
    @GeneratedValue
    @Column(name = "")
    private String id;

}
