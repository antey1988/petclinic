package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Integer> {
    List<Specialty> findAll();
    List<Specialty> findByNameContaining(String name);
}

