package com.example.demo.dao;

import com.example.demo.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientDAO extends JpaRepository<patient,Long> {
}