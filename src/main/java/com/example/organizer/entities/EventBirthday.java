package com.example.organizer.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "birthdayevent", schema = "public", catalog = "organizerDB")
public class EventBirthday {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "birthdaydate", nullable = true)
    private Date birthdaydate;

    @Column(name = "birthdaytime", nullable = true)
    private Time birthdaytime;

    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Column(name = "present", nullable = true, length = 255)
    private String present;

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

    public Date getBirthdaydate() {
        return birthdaydate;
    }

    public void setBirthdaydate(Date birthdaydate) {
        this.birthdaydate = birthdaydate;
    }

    public Time getBirthdaytime() {
        return birthdaytime;
    }

    public void setBirthdaytime(Time birthdaytime) {
        this.birthdaytime = birthdaytime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
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
        EventBirthday entity = (EventBirthday) o;
        if (id != entity.id) return false;
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
