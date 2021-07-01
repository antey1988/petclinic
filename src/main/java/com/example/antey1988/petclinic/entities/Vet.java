package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.PersonEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends PersonEntity {
    @ManyToMany
    @JoinTable(name = "vets_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties;

    public Set<Specialty> getSpecialties() {
        if (specialties == null) {
            specialties = new HashSet<>();
        }
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public boolean addSpecialty(Specialty specialty) {
        if (specialties == null) {
            specialties = new HashSet<>();
        }
        return specialties.add(specialty);
    }

    public boolean removeSpecialty(Specialty specialty) {
        return specialties.remove(specialty);
    }
}
