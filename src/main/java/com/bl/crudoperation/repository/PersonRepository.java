package com.bl.crudoperation.repository;

import com.bl.crudoperation.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PersonRepository implements IPersonRepository {
    private List<Person> personList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public void save(Person person) {
        person.setId(counter.incrementAndGet());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        person.setTime(dtf.format(LocalDateTime.now()));
        personList.add(person);
        ObjectMapper ob = new ObjectMapper();
        try {
            ob.writeValue(new File("./src/main/resources/person.json"),personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List display() {
        return personList;
    }
}
