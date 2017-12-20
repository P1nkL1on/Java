package com.example.organizer.repositories;

import com.example.organizer.entities.EventBirthday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthdayRepository extends CrudRepository<EventBirthday, Long> {
    Iterable<EventBirthday> findAllByOrderByIdAsc();
}
