package com.example.antey1988.petclinic.repos;

import com.example.antey1988.petclinic.entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

@DataJpaTest
class AddressRepositoryTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void testInsert() {
        Address address = new Address();
        address.setCity("Rostov");
        address.setStreet("Zhukova");
        address.setHouse(1);
        Address _address = addressRepository.save(address);
        Assert.notNull(_address, "Адрес не сохранился в базе данных");
        System.out.println("\n" + _address + "\n");
    }

    @Test
    public void testRead() {
        Address _address  = addressRepository.findById(1).get();
        Assert.notNull(_address, "Адрес отсутсвует в базе данных");
    }

    @Test
    public void testDelete() {
        long countRecords = addressRepository.count();
        Address address = new Address();
        addressRepository.save(address);
        addressRepository.deleteById(address.getId());
        Assert.isTrue(countRecords == addressRepository.count(), "Удаление записи не произведено");

    }
}