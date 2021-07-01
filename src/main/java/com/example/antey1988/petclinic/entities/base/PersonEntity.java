package com.example.antey1988.petclinic.entities.base;

import com.example.antey1988.petclinic.entities.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public class PersonEntity extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
