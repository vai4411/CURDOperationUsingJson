package com.bl.crudoperation.controller;

import com.bl.crudoperation.model.Person;
import com.bl.crudoperation.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) throws IOException {
        personService.save(person);
    }
}
