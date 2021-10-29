package com.project.backend.domain;


import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipcode;

    private String cityName;
}
