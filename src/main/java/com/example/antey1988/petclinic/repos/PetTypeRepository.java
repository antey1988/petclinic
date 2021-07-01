package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Pet;
import com.example.antey1988.petclinic.entities.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
}
