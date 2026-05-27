package com.example.demo.dao;

import com.example.demo.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface patientDAO extends JpaRepository<patient, Long> {

    // Search by name (case-insensitive, partial match)
    List<patient> findByNameContainingIgnoreCase(String name);

}