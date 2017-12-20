package com.example.organizer.convertors;

import com.example.organizer.dtos.PersonDTO;
import com.example.organizer.entities.Person;

public class PersonConvertor {

    public static Person toEntity(PersonDTO dto) {
        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setAge(dto.getAge());
        entity.setName(dto.getName());
        return entity;
    }

    public static PersonDTO toDTO(Person entity) {
        PersonDTO dto = new PersonDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        return dto;
    }
}
