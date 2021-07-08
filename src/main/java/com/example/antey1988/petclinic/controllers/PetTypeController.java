package com.example.antey1988.petclinic.controllers;


import com.example.antey1988.petclinic.entities.PetType;
import com.example.antey1988.petclinic.entities.Specialty;
import com.example.antey1988.petclinic.repos.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/pettypes")
public class PetTypeController {
    @Autowired
    PetTypeRepository petTypeRepository;

    @GetMapping
    public ResponseEntity<Set<PetType>> getAllPetTypes() {
        Set<PetType> petTypes = new HashSet<>(petTypeRepository.findAll());
        return new ResponseEntity<>(petTypes, HttpStatus.OK);
    }
}
