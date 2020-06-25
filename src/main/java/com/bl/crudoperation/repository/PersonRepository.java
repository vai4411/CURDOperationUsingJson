/**********************************************************************
 * @purpose : Person Repository Used For Perform CURD Operation
 * @author : Vaibhav Patil
 * @date : 25/6/2020
 **********************************************************************/
package com.bl.crudoperation.repository;

import com.bl.crudoperation.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PersonRepository implements IPersonRepository {
    private LinkedList<Person> personList = new LinkedList<>();
    private final AtomicLong counter = new AtomicLong();

    /**+
     * @purpose : Writing Data In Json File
     * @param personList
     */
    public void writeData(LinkedList personList) {
        ObjectMapper ob = new ObjectMapper();
        try {
            ob.writeValue(new File("./src/main/resources/person.json"),personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**+
     * @purpose : Storing Data Into Json File
     * @param person
     */
    public void save(Person person) {
        long id = person.getId() != 0 ? person.getId() : counter.incrementAndGet();
        person.setId(id);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        person.setTime(dtf.format(LocalDateTime.now()));
        personList.add((int) id - 1,person);
        writeData(personList);
    }

    /**+
     * @purpose : Display All Person Entries From Json File
     * @return : List Of Persons
     */
    @Override
    public List display() {
        return personList;
    }

    /**+
     * @purpose : Display Particular Person Using Id
     * @param id
     * @return : Person
     */
    @Override
    public Person displayById(long id) {
        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    /**+
     * @purpose : Update Data In Json File
     * @param id
     * @param person
     */
    @Override
    public void update(int id, Person person) {
        Person person1 = displayById(id);
        person1.setName(person.getName());
        person1.setContactNumber(person.getContactNumber());
        save(person1);
        delete(id);
    }

    /**+
     * @purpose : Delete Data From Json File
     * @param id
     */
    @Override
    public void delete(int id) {
        personList.remove(id - 1);
        writeData(personList);
    }
}
