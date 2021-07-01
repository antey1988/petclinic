package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Integer> {
}
