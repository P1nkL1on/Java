package com.example.organizer.convertors;

import com.example.organizer.dtos.EventMeetingDTO;
import com.example.organizer.entities.EventMeeting;

import java.sql.Date;
import java.sql.Time;

public class MeetConvertor {

    public static EventMeeting toEntity(EventMeetingDTO dto) {
        EventMeeting entity = new EventMeeting();
        entity.setId(dto.getId());
        entity.setMeetingdate(Date.valueOf(dto.getMeetingdate()));
        entity.setMeetingtime(Time.valueOf(dto.getMeetingtime()));
        entity.setInterlocutor(dto.getPerson());
        entity.setDescription(dto.getDescription());
        entity.setPersonId(dto.getPersonId());
        return entity;
    }

    public static EventMeetingDTO toDTO(EventMeeting entity) {
        EventMeetingDTO dto = new EventMeetingDTO();
        dto.setId(entity.getId());
        dto.setMeetingdate(entity.getMeetingdate().toLocalDate());
        dto.setMeetingtime(entity.getMeetingtime().toLocalTime());
        dto.setPerson(entity.getInterlocutor());
        dto.setDescription(entity.getDescription());
        dto.setPersonId(entity.getPersonId());
        return dto;
    }
}
