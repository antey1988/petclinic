package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    Set<Address> findAll();
    Set<Address> findByCityContainingAndStreetContaining(@Param("city")String city, @Param("street")String street);
}
