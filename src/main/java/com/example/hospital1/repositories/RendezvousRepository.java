package com.example.hospital1.repositories;

import com.example.hospital1.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<Rendezvous, String> {
}
