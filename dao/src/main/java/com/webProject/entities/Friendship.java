package com.webProject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "FRIENDSHIP")
public class Friendship implements Serializable{

    @Id
    @MapsId
    @ManyToOne
    @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK1_FRIENDSHIP_PERSON")
    )
    private Person person;

    @Id
    @MapsId
    @ManyToOne
    @JoinColumn(name = "FRIEND_ID", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK2_FRIENDSHIP_PERSON")
    )
    private Person friend;

    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    public Friendship() {
    }

    public Friendship(Person person, Person friend, Date dateFrom) {
        this.person = person;
        this.friend = friend;
        this.dateFrom = dateFrom;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Friendship that = (Friendship) o;

        return new EqualsBuilder()
                .append(getPerson(), that.getPerson())
                .append(getFriend(), that.getFriend())
                .append(getDateFrom(), that.getDateFrom())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(25, 45)
                .append(getPerson())
                .append(getFriend())
                .append(getDateFrom())
                .toHashCode();
    }
}
