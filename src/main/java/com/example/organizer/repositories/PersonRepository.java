package com.example.organizer.repositories;

import com.example.organizer.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Iterable<Person> findAllByOrderByIdAsc();
}
