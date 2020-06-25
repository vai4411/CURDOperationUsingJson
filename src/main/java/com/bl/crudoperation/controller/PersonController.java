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

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) throws IOException {
        personService.save(person);
    }

    @GetMapping("/displayAll")
    public List displayPerson() {
        return personService.display();
    }
}
