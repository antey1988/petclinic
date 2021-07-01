package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Specialty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpecialtyRepositoryTest {
    @Autowired
    SpecialtyRepository specialtyRepository;

    @Test
    public void testInsert() {
        Specialty specialty = new Specialty();
        specialty.setName("doctor");
        specialtyRepository.save(specialty);
        Assert.notNull(specialty, "Запись не сохранилась в базе данных");
    }

    @Test
    public void testRead() {
        Specialty specialty  = specialtyRepository.findById(1).get();
        Assert.notNull(specialty, "Запись отсутсвует в базе данных");
    }

    @Test
    public void testDelete() {
        long countRecords = specialtyRepository.count();
        Specialty specialty = new Specialty();
        specialtyRepository.save(specialty);
        specialtyRepository.deleteById(specialty.getId());
        Assert.isTrue(countRecords == specialtyRepository.count(), "Удаление записи не произведено");

    }
}