package com.example.demo.controller;

import com.example.demo.dao.patientDAO;
import com.example.demo.model.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    private patientDAO dao;

    @GetMapping("/")
    public String home() {
        return "patient";
    }

    @PostMapping("/savePatient")
    public String savePatient(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String gender,
            @RequestParam String phone,
            @RequestParam String address
    ) {

        patient p = new patient(
                name,
                age,
                gender,
                phone,
                address
        );

        dao.save(p);

        return "redirect:/";
    }
}