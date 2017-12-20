package com.example.organizer.dtos;

import com.example.organizer.entities.Person;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventMeetingDTO {
    private long id;
    private LocalDate meetingdate;
    private LocalTime meetingtime;
    private String person;
    private String description;
    private long personId;

    public void setArgs (long Id, PersonDTO _person,
                         LocalDate _meetingdate, LocalTime _meetingtime,
                         String _description ){
        setId(Id);
        setMeetingdate(_meetingdate);
        setMeetingtime(_meetingtime);
        setDescription(_description);
        setPerson(_person.getName());
        setPersonId(_person.getId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getMeetingdate() {
        return meetingdate;
    }

    public void setMeetingdate(LocalDate meetingdate) {
        this.meetingdate = meetingdate;
    }

    public LocalTime getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(LocalTime meetingtime) {
        this.meetingtime = meetingtime;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
        return "Eventmeet:\n" + "    ID\t" + id + "    DATE\t" + meetingdate +
                "    TIME\t" + meetingtime + "\n    WITH\t'" + person + '\'' +
                "    DESCR\t'" + description + '\'' + "    PERSON ID\t" + personId + '\n';
    }
}
