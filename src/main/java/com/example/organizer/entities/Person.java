package com.example.organizer.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person", schema = "public", catalog = "organizerDB")
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Column(name = "age", nullable = true)
    private Integer age;

    @OneToMany(mappedBy = "personentity", targetEntity = EventBirthday.class, fetch = FetchType.LAZY)
    private List<EventBirthday> birthdayeventsById;

    @OneToMany(mappedBy = "personentity", targetEntity = EventMeeting.class, fetch = FetchType.LAZY)
    private List<EventMeeting> meetingeventsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person entity = (Person) o;
        if (id != entity.id) return false;
        else return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public List <EventBirthday> getBirthdayeventsById() {
        return birthdayeventsById;
    }

    public void setBirthdayeventsById(List <EventBirthday> birthdayeventsById) {
        this.birthdayeventsById = birthdayeventsById;
    }

    public List <EventMeeting> getMeetingeventsById() {
        return meetingeventsById;
    }

    public void setMeetingeventsById(List <EventMeeting> meetingeventsById) {
        this.meetingeventsById = meetingeventsById;
    }
}
