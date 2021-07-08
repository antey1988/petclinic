package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
//    @Query("SELECT owner FROM Owner owner WHERE owner.firstName LIKE %:firstName% and owner.secondName LIKE %:secondName%")
    @Transactional(readOnly = true)
    List<Owner> findByFirstNameContainingAndSecondNameContaining(@Param("firstName") String firstName, @Param("secondName") String secondName);
    @Query("SELECT owner FROM Owner owner left join fetch owner.pets left join fetch owner.addresses WHERE owner.id = :id")
    @Transactional(readOnly = true)
    Optional<Owner> findById(@Param("id") Integer id);
}
