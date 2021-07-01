package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Address;
import com.example.antey1988.petclinic.entities.Vet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

@DataJpaTest
class VetRepositoryTest {
    @Autowired
    VetRepository vetRepository;

    @Test
    public void testInsert() {
        Vet vet = new Vet();
        vet.setSecondName("Sergey");
        vet.setFirstName("Ivanov");
        vetRepository.save(vet);
        Assert.notNull(vet, "Запись не созранилась в базе данных");
    }

    @Test
    public void testRead() {
        Vet _vet  = vetRepository.findById(1).get();
        Assert.notNull(_vet, "Запись отсутсвует в базе данных");
    }

    @Test
    public void testDelete() {
        long countRecords = vetRepository.count();
        Vet vet = new Vet();
        vetRepository.save(vet);
        vetRepository.deleteById(vet.getId());
        Assert.isTrue(countRecords == vetRepository.count(), "Удаление записи не произведено");

    }
}