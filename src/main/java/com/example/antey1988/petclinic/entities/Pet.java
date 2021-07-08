package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.NameEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends NameEntity {
    @Column(name = "birth_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Owner owner;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "type_id")
    private PetType petType;
    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Visit> getVisits() {
        if (visits == null) {
            visits = new HashSet<>();
        }
        return visits;
    }

    public void setVisits(Set<Visit> visits) {

        this.visits = visits;
    }

    public boolean addVisit(Visit visit) {
        if (visits == null) {
            visits = new HashSet<>();
        }
        return visits.add(visit);
    }

    public boolean removeVisit(Visit visit) {
        return visits.remove(visit);
    }

}
