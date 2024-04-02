package com.example.hospital1.service;

import com.example.hospital1.entities.Consultation;
import com.example.hospital1.entities.Medecin;
import com.example.hospital1.entities.Patient;
import com.example.hospital1.entities.Rendezvous;

public interface IHospitalService {
    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    Consultation saveConsultation(Consultation consultation);

    Rendezvous saveRDV(Rendezvous rendezvous);
}
