package com.webProject.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @Column(name = "TITLE", unique = true, nullable = false, length = 200)
    private String title;

    @Column(name = "CONTENT", unique = false, nullable = false, length = 500)
    private String content;

    @Column(name = "PLACE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placeTime;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID",
            foreignKey = @ForeignKey(name = "FK_POST_PERSON")
    )
    private Person person;

    public Post() {
    }

    public Post(String title, String content, Date placeTime, Person personId) {
        this.title = title;
        this.content = content;
        this.placeTime = placeTime;
        this.person = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        return new EqualsBuilder()
                .append(getTitle(), post.getTitle())
                .append(getContent(), post.getContent())
                .append(getPlaceTime(), post.getPlaceTime())
                .append(getPerson(), post.getPerson())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(25, 45)
                .append(getTitle())
                .append(getContent())
                .append(getPlaceTime())
                .append(getPerson())
                .toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
