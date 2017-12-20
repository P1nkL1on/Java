package com.example.organizer.repositories;

import com.example.organizer.entities.EventMeeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<EventMeeting, Long> {
    Iterable<EventMeeting> findAllByOrderByIdAsc();
}
