package com.example.FinalTrial.person;
//Data Access Layer
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


    Optional<Person> findPersonByPhone(int phone);

    Optional<Person> deletePersonByPhone(int phone);

    Person findByPhone(int phone);

   @Query(value = "SELECT * FROM person WHERE :hobby = any(hobbies)", nativeQuery = true)
   List <Person> findAllByHobbies(@Param("hobby") String hobbies);

}