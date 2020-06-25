/**********************************************************************
 * @purpose : Person Service Interface Used For Managing Service
 * @author : Vaibhav Patil
 * @date : 25/6/2020
 **********************************************************************/
package com.bl.crudoperation.service;

import com.bl.crudoperation.model.Person;

import java.util.List;

public interface IPersonService {
    void save(Person person);
    List display();
    Person displayById(long id);
    void update(int id, Person person);
    void delete(int id);
}
