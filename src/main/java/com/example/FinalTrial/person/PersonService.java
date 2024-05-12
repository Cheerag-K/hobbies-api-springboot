package com.example.FinalTrial.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {


    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPersons() {

        return personRepository.findAll();
    }




    public void addPerson(Person person) {
        Optional<Person> personOptionalPhone= personRepository.findPersonByPhone(person.getPhone());

        if (personOptionalPhone.isPresent()){
            throw new IllegalStateException("Phone number already exists");
        }
        else {
            personRepository.save(person);
        }
    }



    @Transactional
    public void deletePerson(int personPhone) {
        Optional<Person> exists;

        exists= personRepository.findPersonByPhone(personPhone);

        if (exists.isEmpty()) {
            throw new IllegalStateException("Person with Phone :"+ personPhone + " does not exist in system");
        }

        else {
            personRepository.deletePersonByPhone(personPhone);      //calling deletePersonByPhone method
        }
    }



    @Transactional
    public void updateName(int personPhone, String name) {
        Person person= personRepository.findByPhone(personPhone);

        if (person == null) {
            throw new IllegalStateException("Person with Phone :"+ personPhone + " does not exist in system");}

        else if (name==null) {}

        else {person.setName(name);}
    }


    @Transactional
    public void updateAddress(int personPhone, String address) {
        Person person= personRepository.findByPhone(personPhone);

        if (person == null) {
            throw new IllegalStateException("Person with Phone :"+ personPhone + " does not exist in system");}

        if (address==null) {}

        else {person.setAddress(address);}
    }



    public List <Person> findAllWithHobby(String hobby) {
        List <Person> allByHobbies = personRepository.findAllByHobbies(hobby);

        if (allByHobbies.isEmpty()) {
            throw new IllegalStateException("Person with chosen Hobby does not exist in system");
        }

        return allByHobbies;

    }


    @Transactional
    public void updateHobbies(int personPhone, String hobbies) {
        Person person= personRepository.findByPhone(personPhone);

        String[] hobbiesArr= hobbies.split(",");

        if (person == null) {
            throw new IllegalStateException("Person with Phone :"+ personPhone + " does not exist in system");
        }

        else if (hobbies!=null && hobbiesArr.length<=5) {
            person.setHobbies(hobbiesArr);
        }

        else if (hobbies!=null && hobbiesArr.length<5) {
            throw new IllegalStateException("Too many inputs. Please enter maximum 5 hobbies");
        }
    }

    @Transactional
    public void deleteHobbies(int personPhone) {
        Person person= personRepository.findByPhone(personPhone);

        if (person == null) {
            throw new IllegalStateException("Person with Phone :"+ personPhone + " does not exist in system");
        }

        else {
            person.setHobbies(null);
        }

    }



}