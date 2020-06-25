/**********************************************************************
 * @purpose : Person Service Used For Service Implementation
 * @author : Vaibhav Patil
 * @date : 25/6/2020
 **********************************************************************/
package com.bl.crudoperation.service;

import com.bl.crudoperation.model.Person;
import com.bl.crudoperation.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public List display() {
        return personRepository.display();
    }

    @Override
    public Person displayById(long id) {
        return personRepository.displayById(id);
    }

    @Override
    public void update(int id, Person person) {
        personRepository.update(id,person);
    }

    @Override
    public void delete(int id) {
        personRepository.delete(id);
    }
}
