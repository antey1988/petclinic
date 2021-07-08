package com.example.antey1988.petclinic.entities;

import com.example.antey1988.petclinic.entities.base.PersonEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends PersonEntity {
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private Set<Pet> pets = new HashSet<>();
    @ManyToMany()
    @JoinTable(name = "owners_addresses", joinColumns = @JoinColumn(name = "owner_id"), inverseJoinColumns = @JoinColumn(name="address_id"))
    private Set<Address> addresses =  new HashSet<>();

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean addAddress(Address address) {
        return addresses.add(address);
    }

    public boolean removeAddress(Address address) {
        return addresses.remove(address);
    }
}
