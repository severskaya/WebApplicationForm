package com.webProject.entities;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "HOBBY")
public class Hobby {

    @Id
    @GeneratedValue
    @Column(name = "HOBBY_ID")
    private Long id;

    @NaturalId
    private String title;

    private String description;

    public Hobby() {}

    public Hobby(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby hobby = (Hobby) o;

        return getTitle().equals(hobby.getTitle());

    }

    @Override
    public int hashCode() {
        return getTitle().hashCode();
    }
}