package com.ecommerce.project.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long addressId;

    @NotBlank
    @Size(min = 2, message = "Street name should be at least 2 characters")
    String street;

    @NotBlank
    @Size(min = 2, message = "building name name should be at least 2 characters")
    String buildingName;

    @NotBlank
    @Size(min = 2, message = "state name should be at least 2 characters")
    String state;

    @NotBlank
    @Size(min = 2, message = "city name should be at least 2 characters")
    String city;

    @NotBlank
    @Size(min = 2, message = "country name should be at least 2 characters")
    String country;

    @NotBlank
    @Size(min = 5, message = "pincode name should be at least 5 characters")
    String pincode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    List<User> users = new ArrayList<>();

    public Address(String street, String buildingName, String state, String city, String country, String pincode) {
        this.street = street;
        this.buildingName = buildingName;
        this.state = state;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
    }
}
