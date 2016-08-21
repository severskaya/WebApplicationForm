package com.webProject.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "POST_LIKES")
public class PostLikes implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "POST_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_POST_LIKES_POST")
    )
    private Post post;

    @Id
    @ManyToOne
    @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_POST_LIKES_PERSON")
    )
    private Person person;

    public PostLikes() {
    }

    public PostLikes(Person person, Post post) {
        this.post = post;
        this.person = person;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PostLikes postLikes = (PostLikes) o;

        return new EqualsBuilder()
                .append(getPost(), postLikes.getPost())
                .append(getPerson(), postLikes.getPerson())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(25, 45)
                .append(getPost())
                .append(getPerson())
                .toHashCode();
    }
}
