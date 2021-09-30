package com.project.backend.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
    private String name;

    private String city;
    private String street;
    private String zipcode;
}