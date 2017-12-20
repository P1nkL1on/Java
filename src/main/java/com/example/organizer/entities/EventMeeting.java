package com.example.organizer.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="meetingevent", schema = "public", catalog = "organizerDB")
public class EventMeeting {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "meetingdate", nullable = true)
    private Date meetingdate;

    @Column(name = "meetingtime", nullable = true)
    private Time meetingtime;

    @Column(name = "interlocutor", nullable = true, length = 255)
    private String interlocutor;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Column(name = "person_id", nullable = false)
    private long personId;

    @ManyToOne
    @JoinColumn(name = "person_entity", referencedColumnName = "id", nullable = true)
    private Person personentity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getMeetingdate() {
        return meetingdate;
    }

    public void setMeetingdate(Date meetingdate) {
        this.meetingdate = meetingdate;
    }

    public Time getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(Time meetingtime) {
        this.meetingtime = meetingtime;
    }

    public String getInterlocutor() {
        return interlocutor;
    }

    public void setInterlocutor(String interlocutor) {
        this.interlocutor = interlocutor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        EventMeeting that = (EventMeeting) o;
        if (id != that.id) return false;
        else return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public Person getPersonEntity() {
        return personentity;
    }

    public void setPersonEntity(Person personentity) {
        this.personentity = personentity;
    }
}
