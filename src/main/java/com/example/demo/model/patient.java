package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "patients")
public class patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Min(value = 0, message = "Age must be positive")
    @Max(value = 150, message = "Age must be realistic")
    @Column(nullable = false)
    private int age;

    @NotBlank(message = "Gender is required")
    @Column(nullable = false)
    private String gender;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Address is required")
    @Column(nullable = false)
    private String address;

    // Constructors
    public patient() {}

    public patient(String name, int age, String gender, String phone, String address) {
        this.name    = name;
        this.age     = age;
        this.gender  = gender;
        this.phone   = phone;
        this.address = address;
    }

    // Getters & Setters
    public Long getId()               { return id; }
    public void setId(Long id)        { this.id = id; }

    public String getName()           { return name; }
    public void setName(String name)  { this.name = name; }

    public int getAge()               { return age; }
    public void setAge(int age)       { this.age = age; }

    public String getGender()              { return gender; }
    public void setGender(String gender)   { this.gender = gender; }

    public String getPhone()               { return phone; }
    public void setPhone(String phone)     { this.phone = phone; }

    public String getAddress()             { return address; }
    public void setAddress(String address) { this.address = address; }
}