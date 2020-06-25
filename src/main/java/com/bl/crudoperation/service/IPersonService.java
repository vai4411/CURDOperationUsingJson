package com.bl.crudoperation.service;

import com.bl.crudoperation.model.Person;

import java.util.List;

public interface IPersonService {
    void save(Person person);
    List display();
    Person displayById(long id);
}
