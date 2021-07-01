package com.example.antey1988.petclinic.controllers;


import com.example.antey1988.petclinic.entities.Specialty;
import com.example.antey1988.petclinic.repos.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/specialties")
public class SpecialtyController {
    @Autowired
    SpecialtyRepository specialtyRepository;

    @GetMapping
    public ResponseEntity<Set<Specialty>> getAllSpecialties(@RequestParam(name = "name", required = false)String name) {
        Set<Specialty> specialties = new HashSet<>();
        if (name == null) {
            specialties.addAll(specialtyRepository.findAll());
        } else {
            specialties.addAll(specialtyRepository.findByNameContaining(name));
        }
        return new ResponseEntity<>(specialties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable("id") Integer id) {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        return specialty.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
