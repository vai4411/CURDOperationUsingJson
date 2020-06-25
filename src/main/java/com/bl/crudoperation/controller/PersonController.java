/**********************************************************************
 * @purpose : Person Controller Use For Handling Request And Response
 * @author : Vaibhav Patil
 * @date : 25/6/2020
 **********************************************************************/
package com.bl.crudoperation.controller;

import com.bl.crudoperation.model.Person;
import com.bl.crudoperation.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService personService;

    /**+
     * @purpose : Post Mapping Used For Storing Data
     * @param person
     * @throws IOException
     */
    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) throws IOException {
        personService.save(person);
    }

    /**+
     * @purpose : Get Mapping Used For Display All Entries
     * @return : List Of Persons
     */
    @GetMapping("/displayAll")
    public List displayAll() {
        return personService.display();
    }

    /**+
     * @purpose : Get Mapping Used For Display Particular Person
     * @param id
     * @return : Person
     */
    @GetMapping("/displayPerson/{id}")
    public Person displayPerson(@PathVariable long id) {
        return personService.displayById(id);
    }

    /**+
     * @purpose : Put Mapping Used For Update Data
     * @param id
     * @param person
     */
    @PutMapping("/update/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody Person person) {
        personService.update(id, person);
    }

    /**+
     * @purpose : Delete Mapping Used For Delete Data
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.delete(id);
    }
}
