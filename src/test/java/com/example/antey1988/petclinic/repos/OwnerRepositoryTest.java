package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Address;
import com.example.antey1988.petclinic.entities.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

@DataJpaTest
class OwnerRepositoryTest {
    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void testInsert() {
        Owner owner  = new Owner();
        owner.setFirstName("Petr");
        owner.setSecondName("Petrov");
        long countRecords = ownerRepository.count();
        ownerRepository.save(owner);
        Assert.notNull(owner, "Запись не сохранился в базе данных");
        Assert.isTrue(owner.getId() == countRecords+1, "Айди сохраненной записи должен быть равен " + countRecords);
    }

    @Test
    public void testRead() {
        Owner _owner  = ownerRepository.findById(1).get();
        Assert.notNull(_owner, "Запись о пользователе отсутсвует в базе данных");
    }

    @Test
    public void testDelete() {
        long countRecords = ownerRepository.count();
        ownerRepository.deleteById(1);
        Assert.isTrue(countRecords-1 == ownerRepository.count(), "Удаление записи не произведено");
    }
}