package com.example.demo.model;

public class patient {

    private String name;
    private int age;
    private String gender;
    private String phone;
    private String address;

    public patient(String name, int age,
                   String gender,
                   String phone,
                   String address) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}