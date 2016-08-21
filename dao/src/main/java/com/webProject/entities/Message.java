package com.webProject.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "FIRST_NAME")

@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_FROM",
            foreignKey = @ForeignKey(name = "FK1_MESSAGE_PERSON")
    )
    private Person personFrom;

    @ManyToOne
    @JoinColumn(name = "PERSON_TO",
            foreignKey = @ForeignKey(name = "FK2_MESSAGE_PERSON")
    )
    private Person personTo;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TIME_SENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSent;

    public Message() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message message = (Message) o;

        return new EqualsBuilder()
                .append(getContent(), message.getContent())
                .append(getTimeSent(), message.getTimeSent())
                .append(getPersonFrom(), message.getPersonFrom())
                .append(getPersonTo(), message.getPersonTo())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(25, 45)
                .append(getContent())
                .append(getTimeSent())
                .append(getPersonFrom())
                .append(getPersonTo())
                .toHashCode();
    }

    public Long getId() {
        return id;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public Person getPersonFrom() {
        return personFrom;
    }

    public Person getPersonTo() {
        return personTo;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    public void setPersonFrom(Person personFrom) {
        this.personFrom = personFrom;
    }

    public void setPersonTo(Person personTo) {
        this.personTo = personTo;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
