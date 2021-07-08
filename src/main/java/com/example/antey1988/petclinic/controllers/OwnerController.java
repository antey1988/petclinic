package com.example.antey1988.petclinic.controllers;


import com.example.antey1988.petclinic.entities.Address;
import com.example.antey1988.petclinic.entities.Owner;
import com.example.antey1988.petclinic.repos.AddressRepository;
import com.example.antey1988.petclinic.repos.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/owners")
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners(@RequestParam(name = "firstName", defaultValue = "")String firstName,
                                                       @RequestParam(name = "secondName", defaultValue = "")String secondName) {
        List<Owner> owners = new ArrayList<>(ownerRepository.findByFirstNameContainingAndSecondNameContaining(firstName, secondName));
        owners.forEach(owner->{
            owner.setAddresses(new HashSet<>());
            owner.setPets(new HashSet<>());
        });
        ResponseEntity<List<Owner>> responseEntity = new ResponseEntity<>(owners, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable("id") Integer id) {
        Optional<Owner> _owner = ownerRepository.findById(id);

        if (_owner.isPresent()) {
            Owner owner = _owner.get();
            return new ResponseEntity<>(owner, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
