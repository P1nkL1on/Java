package com.example.organizer.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventBirthdayDTO {
    private long id;
    private LocalDate birthdaydate;
    private LocalTime birthdaytime;
    private String name;
    private String present;
    private String description;
    private long personId;

    public void setArgs (long Id, PersonDTO _person,
                         LocalDate _meetingdate, LocalTime _meetingtime,
                         String _description, String _present ){
        setId( Id);
        setBirthdaydate(_meetingdate);
        setBirthdaytime(_meetingtime);
        setDescription(_description);
        setName(_person.getName());
        setPersonId(_person.getId());
        setPresent(_present);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthdaydate() {
        return birthdaydate;
    }

    public void setBirthdaydate(LocalDate birthdaydate) {
        this.birthdaydate = birthdaydate;
    }

    public LocalTime getBirthdaytime() {
        return birthdaytime;
    }

    public void setBirthdaytime(LocalTime birthdaytime) {
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
    public String toString() {
        return "Eventbirthday:\n" + "    ID\t" + id + "    DATE\t" + birthdaydate +
                "    TIME\t" + birthdaytime + "\n    NAME\t\'" + name + '\'' +
                "    PRESENT\t'" + present + '\'' + "    DESCR\t'" + description + '\'' +
                "    Person ID\t" + personId + '\n';
    }
}
