package com.example.organizer.services;

import com.example.organizer.convertors.MeetConvertor;
import com.example.organizer.dtos.EventMeetingDTO;
import com.example.organizer.entities.EventMeeting;
import com.example.organizer.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository repository;

    public void add(EventMeetingDTO dto) {
        repository.save(MeetConvertor.toEntity(dto));
        System.out.println("#Meet added!");
    }

    public EventMeetingDTO edit(EventMeetingDTO dto) {
        if (get(dto.getId()) != null) {
            EventMeeting entity = repository.save(MeetConvertor.toEntity(dto));
            System.out.println("#Meet edited!");
            return MeetConvertor.toDTO(entity);
        }
        else throw new IllegalStateException("edit method");
    }

    public void delete(long id) {
        repository.delete(id);
        System.out.println("#Meet deleted!");
    }

    public EventMeetingDTO get(long id) {
        EventMeeting entity = repository.findOne(id);
        if (entity != null) return MeetConvertor.toDTO(entity);
        else throw new IllegalStateException("get method");
    }

    public Iterable<EventMeetingDTO> getAll() {
        LinkedList<EventMeetingDTO> list = new LinkedList<>();
        for (EventMeeting entity : repository.findAllByOrderByIdAsc())
            list.add(MeetConvertor.toDTO(entity));
        if (list != null) return list;
        else throw new IllegalStateException("There are no elements");
    }
}
