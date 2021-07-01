package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Pet;
import com.example.antey1988.petclinic.entities.PetType;
import com.example.antey1988.petclinic.entities.Vet;
import com.example.antey1988.petclinic.entities.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.util.Date;

@DataJpaTest
class PetRepositoryTest {
    @Autowired
    PetRepository petRepository;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    PetTypeRepository petTypeRepository;

    @Test
    public void testInsert() {
        Pet pet = new Pet();
        pet.setName("Tobik");
        pet.setBirthDate(new Date());
        pet.setPetType(petTypeRepository.findById(1).get());
        pet.setOwner(ownerRepository.findById(1).get());
        petRepository.save(pet);
        Assert.notNull(pet, "Запись не созранилась в базе данных");
        System.out.println(pet);
    }

    @Test
    public void testRead() {
        Pet pet  = petRepository.findById(1).get();
        Assert.notNull(pet, "Запись отсутсвует в базе данных");
    }

    @Test
    public void testDelete() {
        long countRecords = petRepository.count();
        petRepository.deleteById(1);
        Assert.isTrue(countRecords - 1 == petRepository.count(), "Удаление записи не произведено");

    }
}