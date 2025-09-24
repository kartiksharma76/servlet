package com.example.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private LocalDate dob; // Date of Birth

    public User(String name, String email, String phone, String address, String gender, String dob) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        if (dob != null && !dob.trim().isEmpty()) {
            this.dob = LocalDate.parse(dob);
        }
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getGender() { return gender; }
    public String getDobFormatted() {
        return dob != null ? dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "N/A";
    }
}