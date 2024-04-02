package com.example.hospital1.repositories;

import com.example.hospital1.entities.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
