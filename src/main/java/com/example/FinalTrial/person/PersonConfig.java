package com.example.FinalTrial.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class PersonConfig {


    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {

            Person walter= new Person("Walter White", "308 Negro Arroyo",
                    12345, new String[]{"Jogging", "Walking", "Hiking"});

            Person jesse= new Person( "Jesse Pinkman", "9809 Margo Street",
                    56789, new String[]{"VideoGames", "Hiking", "Partying"});

            Person saul= new Person( "Saul Goodman", "9800 Montgomery Blvd ",
                    78452, new String[]{"Debating", "Walking" });

            Person gus= new Person( "Gustavo Fring", "1213 Jefferson St",
                    66666, new String[]{"Swimming", "Hiking", "Gaming", "Chess"});

            Person mike= new Person( "Mike Ehrmantraut", "204 Edith Blvd ",
                    58790, new String[]{"Boxing", "Shooting", "Walking"});

            repository.saveAll(List.of(walter, jesse, saul, gus, mike));
        };

    }

}
