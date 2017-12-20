package com.example.organizer.convertors;

import com.example.organizer.dtos.EventBirthdayDTO;
import com.example.organizer.entities.EventBirthday;

import java.sql.Date;
import java.sql.Time;

public class BDayConvertor {

    public static EventBirthday toEntity(EventBirthdayDTO dto) {
        EventBirthday entity = new EventBirthday();
        entity.setId(dto.getId());
        entity.setBirthdaydate(Date.valueOf(dto.getBirthdaydate()));
        entity.setBirthdaytime(Time.valueOf(dto.getBirthdaytime()));
        entity.setName(dto.getName());
        entity.setPresent(dto.getPresent());
        entity.setDescription(dto.getDescription());
        entity.setPersonId(dto.getPersonId());
        return entity;
    }

    public static EventBirthdayDTO toDTO(EventBirthday entity) {
        EventBirthdayDTO dto = new EventBirthdayDTO();
        dto.setId(entity.getId());
        dto.setBirthdaydate(entity.getBirthdaydate().toLocalDate());
        dto.setBirthdaytime(entity.getBirthdaytime().toLocalTime());
        dto.setName(entity.getName());
        dto.setPresent(entity.getPresent());
        dto.setDescription(entity.getDescription());
        dto.setPersonId(entity.getPersonId());
        return dto;
    }
}
