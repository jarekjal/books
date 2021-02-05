package com.jarekjal.books.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

public class Author {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "street",
                    column = @Column(nullable = false, name = "author_address_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(nullable = false, name = "author_address_city")
            )
    })
    private Address address;

    public Author() {
    }

    public Author(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
