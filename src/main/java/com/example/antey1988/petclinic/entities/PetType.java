package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.NameEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends NameEntity {
}
