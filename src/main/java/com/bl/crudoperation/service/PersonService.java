package com.bl.crudoperation.service;

import com.bl.crudoperation.model.Person;
import com.bl.crudoperation.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }
}
