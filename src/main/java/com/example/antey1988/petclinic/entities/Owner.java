package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.PersonEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends PersonEntity {
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets;
    @ManyToMany
    @JoinTable(name = "owners_addresses", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<Address> addresses;

    public Set<Address> getAddresses() {
        if (addresses == null) {
            addresses = new HashSet<>();
        }
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean addAddress(Address address) {
        if (addresses == null) {
            addresses = new HashSet<>();
        }
        return addresses.add(address);
    }

    public boolean removeAddress(Address address) {
        return addresses.remove(address);
    }
}
