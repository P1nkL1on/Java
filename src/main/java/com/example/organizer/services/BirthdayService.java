package com.example.organizer.services;

import com.example.organizer.convertors.BDayConvertor;
import com.example.organizer.dtos.EventBirthdayDTO;
import com.example.organizer.entities.EventBirthday;
import com.example.organizer.repositories.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class BirthdayService {

    @Autowired
    private BirthdayRepository repository;

    public void add(EventBirthdayDTO dto) {
        repository.save(BDayConvertor.toEntity(dto));
        System.out.println("#Bday added!");
    }

    public EventBirthdayDTO edit(EventBirthdayDTO dto) {
        if (get(dto.getId()) != null) {
            EventBirthday entity = repository.save(BDayConvertor.toEntity(dto));
            System.out.println("#Bday edited!");
            return BDayConvertor.toDTO(entity);
        }
        else throw new IllegalStateException("edit method");
    }

    public void delete(long id) {
        repository.delete(id);
        System.out.println("#Bday deleted!");
    }

    public EventBirthdayDTO get(long id) {
        EventBirthday entity = repository.findOne(id);
        if (entity != null) return BDayConvertor.toDTO(entity);
        else throw new IllegalStateException("get method");
    }

    public Iterable<EventBirthdayDTO> getAll() {
        LinkedList<EventBirthdayDTO> list = new LinkedList<>();
        for (EventBirthday entity : repository.findAllByOrderByIdAsc())
            list.add(BDayConvertor.toDTO(entity));
        if (list != null) return list;
        else throw new IllegalStateException("There are no elements");
    }
}
