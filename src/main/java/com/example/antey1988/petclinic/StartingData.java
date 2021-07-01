package com.example.antey1988.petclinic;

import com.example.antey1988.petclinic.entities.Address;
import com.example.antey1988.petclinic.entities.Owner;
import com.example.antey1988.petclinic.entities.Specialty;
import com.example.antey1988.petclinic.entities.Vet;
import com.example.antey1988.petclinic.repos.AddressRepository;
import com.example.antey1988.petclinic.repos.OwnerRepository;
import com.example.antey1988.petclinic.repos.SpecialtyRepository;
import com.example.antey1988.petclinic.repos.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class StartingData implements CommandLineRunner {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    VetRepository vetRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address();
        address.setCity("Rostov-on-Don");
        address.setStreet("str. Zorge");
        address.setHouse(5);
        addressRepository.save(address);

        Owner owner = new Owner();
        owner.addAddress(address);
        owner.setFirstName("Oleg");
        owner.setSecondName("Petorv");
        ownerRepository.save(owner);

        Specialty specialty = new Specialty();
        specialty.setName("lor");
        specialtyRepository.save(specialty);

        Vet vet = new Vet();
        vet.addSpecialty(specialty);
        vet.setFirstName("Olga");
        vet.setSecondName("Petrova");

        vetRepository.save(vet);

    }
}
