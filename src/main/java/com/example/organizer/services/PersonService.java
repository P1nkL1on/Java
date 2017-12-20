package com.example.organizer.services;

import com.example.organizer.convertors.PersonConvertor;
import com.example.organizer.dtos.PersonDTO;
import com.example.organizer.entities.Person;
import com.example.organizer.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public void add(PersonDTO dto) {
        System.out.println("#Person added!");
        repository.save(PersonConvertor.toEntity(dto));
    }

    public PersonDTO edit(PersonDTO dto) {
        if (get(dto.getId()) != null) {
            Person entity = repository.save(PersonConvertor.toEntity(dto));
            System.out.println("#Person changed!");
            return PersonConvertor.toDTO(entity);
        }
        else throw new IllegalStateException("edit method");
    }

    public void delete(long id) {
        System.out.println("#Person deleted!");
        repository.delete(id);
    }

    public PersonDTO get(long id) {
        Person entity = repository.findOne(id);
        if (repository.findOne(id) != null) return PersonConvertor.toDTO(entity);
        else throw new IllegalStateException("get method");
    }

    public Iterable<PersonDTO> getAll() {
        LinkedList<PersonDTO> list = new LinkedList<>();
        for (Person entity : repository.findAllByOrderByIdAsc())
            list.add(PersonConvertor.toDTO(entity));
        if (list != null) return list;
        else throw new IllegalStateException("There are no elements");
    }
}
