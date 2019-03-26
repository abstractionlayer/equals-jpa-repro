package com.example.demo.model;

import javax.persistence.Entity;


@Entity
public class Author extends BaseDomainEntity { // NOSONAR for equals

    private String name;


    public Author(String name) {
        this.name = name;
    }


    protected Author() {

    }


    public String getName() {
        return name;
    }
}
