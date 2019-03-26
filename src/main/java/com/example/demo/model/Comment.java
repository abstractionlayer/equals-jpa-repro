package com.example.demo.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Comment extends BaseDomainEntity { // NOSONAR for equals

    private String text;

    @ManyToOne(fetch=LAZY, cascade=ALL, optional=false)
    private Author author;


    public Comment(String text, Author author) {
        this.text = text;
        this.author = author;
    }


    protected Comment() { }


    public String getText() {
        return text;
    }


    public Author getAuthor() {
        return author;
    }


    public boolean isBelongTo(Author owner) {
        return owner.equals(author);
    }
}
