package com.example.hospital1.service;

import com.example.hospital1.entities.Consultation;
import com.example.hospital1.entities.Medecin;
import com.example.hospital1.entities.Patient;
import com.example.hospital1.entities.Rendezvous;
import com.example.hospital1.repositories.ConsultationRepository;
import com.example.hospital1.repositories.MedecinRepository;
import com.example.hospital1.repositories.PatientRepository;
import com.example.hospital1.repositories.RendezvousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezvousRepository rendezvousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezvousRepository rendezvousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezvousRepository = rendezvousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }


    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Rendezvous saveRDV(Rendezvous rendezvous) {
        rendezvous.setId(UUID.randomUUID().toString());
        return rendezvousRepository.save(rendezvous);
    }
}
