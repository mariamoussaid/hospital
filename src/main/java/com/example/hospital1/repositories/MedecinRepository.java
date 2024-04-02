package com.example.hospital1.repositories;

import com.example.hospital1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital1.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);

}
