package com.example.FinalTrial.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/persons/v1")
public class PersonController {



    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public void newPerson(@RequestBody Person person) {     //@RequestBody means that Person will be taken from JSON of user input
        personService.addPerson(person);
    }

    @DeleteMapping(path= "{personPhone}")
    public void deletePerson(@PathVariable("personPhone") int personPhone,
                             @RequestParam(required = false) String flag) {

        if (flag != null) {
            personService.deleteHobbies(personPhone);
        }

        else {
            personService.deletePerson(personPhone);
        }
    }

    @PutMapping(path="{personPhone}")
    public void updateDetails(@PathVariable("personPhone") int personPhone,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String address,
                              @RequestParam(required = false) String hobbies) {


        if (hobbies != null) {

            personService.updateHobbies(personPhone, hobbies);

            if (name != null && address != null) {
                personService.updateAddress(personPhone, address);
                personService.updateName(personPhone, name);
            } else if (name == null && address != null) {
                personService.updateAddress(personPhone, address);
            } else if (name != null && address == null) {
                personService.updateName(personPhone, name);
            }
        }

        else if (hobbies == null) {
             if (name != null && address != null && hobbies == null) {
                personService.updateAddress(personPhone, address);
                personService.updateName(personPhone, name);}

            else if (name == null && address != null && hobbies == null) {
                personService.updateAddress(personPhone, address);}

            else if (name != null && address == null && hobbies == null) {
                personService.updateName(personPhone, name);}
        }


    }


    @GetMapping(path="{hobby}")
    public List<Person> findByHobbies(@PathVariable("hobby") String hobby) {
        return personService.findAllWithHobby(hobby);
    }



}