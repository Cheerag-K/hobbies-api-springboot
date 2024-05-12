package com.example.FinalTrial.person;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table
public class Person {

    @Id
    @SequenceGenerator(
            name="person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private int id;
    private String name;
    private String address;
    private int phone;


    private String[] hobbies= new String[5];


    public Person() {
    }


    public Person(int id,String name, String address, int phone, String[] hobbies) {
        this.id= id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
    }


    public Person(String name, String address, int phone, String[] hobbies) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }
}
