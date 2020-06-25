/**********************************************************************
 * @purpose : Person Repository Interface Used For Managing Repository
 * @author : Vaibhav Patil
 * @date : 25/6/2020
 **********************************************************************/
package com.bl.crudoperation.repository;

import com.bl.crudoperation.model.Person;

import java.util.List;

public interface IPersonRepository {
    void save(Person person);
    List display();
    Person displayById(long id);
    void update(int id, Person person);
    void delete(int id);
}
