package com.example.antey1988.petclinic.controllers;


import com.example.antey1988.petclinic.entities.Address;
import com.example.antey1988.petclinic.entities.Specialty;
import com.example.antey1988.petclinic.repos.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<Set<Address>> getAllAddresses(@RequestParam(name = "city", defaultValue = "")String city,
                                                           @RequestParam(name = "street", defaultValue = "")String street) {
        /*if (city == null) city = "";
        if (street == null) street = "";*/
        Set<Address> addresses = new HashSet<>(addressRepository.findByCityContainingAndStreetContaining(city, street));
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
