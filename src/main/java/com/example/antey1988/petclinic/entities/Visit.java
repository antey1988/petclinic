package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
    @Column(name = "visit_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
