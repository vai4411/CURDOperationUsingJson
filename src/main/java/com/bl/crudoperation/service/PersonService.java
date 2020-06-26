/**********************************************************************
 * @purpose : Person Service Used For Service Implementation
 * @author : Vaibhav Patil
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

    /**+
     * @purpose : Performing Store Operation
     * @param person
     */
    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    /**+
     * @purpose : Display All Persons
     * @return : List Of Persons
     */
    @Override
    public List display() {
        return personRepository.display();
    }

    /**+
     * @purpose : Display Particular Person
     * @param id
     * @return : Person
     */
    @Override
    public Person displayById(long id) {
        return personRepository.displayById(id);
    }

    /**+
     * @purpose : Perform Update Operation
     * @param id
     * @param person
     */
    @Override
    public void update(int id, Person person) {
        personRepository.update(id,person);
    }

    /**+
     * @purpose : Perform Delete Operation
     * @param id
     */
    @Override
    public void delete(int id) {
        personRepository.delete(id);
    }
}
