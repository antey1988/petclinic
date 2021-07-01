package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Vet;
import com.example.antey1988.petclinic.entities.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {
}
