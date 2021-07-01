package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.NameEntity;
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
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @OneToMany(mappedBy = "pet")
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

    @Override
    public String toString() {
        StringBuilder allVisits = new StringBuilder("");
        if (!getVisits().isEmpty()) {
            allVisits.append(", Visits:");
            visits.forEach(visit -> allVisits.append("\n\t").append(visit.toString()));
        }
        return super.toString() +
                ", Birth Date=" + birthDate +
                ", Owner: (" + owner + ")" +
                ", Type: (" + petType + ")" +
                allVisits;
    }
}
