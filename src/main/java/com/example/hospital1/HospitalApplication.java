package com.example.hospital1;

import com.example.hospital1.entities.*;
import com.example.hospital1.service.IHospitalService;
import com.example.hospital1.repositories.ConsultationRepository;
import com.example.hospital1.repositories.RendezvousRepository;
import com.example.hospital1.service.IHospitalService;
import lombok.AllArgsConstructor;
import com.example.hospital1.repositories.MedecinRepository;
import com.example.hospital1.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class HospitalApplication {
    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    RendezvousRepository rendezvousRepository;
    ConsultationRepository consultationRepository;

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }


    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, RendezvousRepository rendezvousRepository, ConsultationRepository consultationRepository, MedecinRepository medecinRepository) { // Assurez-vous que PatientRepository est importé correctement
        return args -> {
            Stream.of("mohammed", "hassan", "najat")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("aymane", "hanane", "yassmina")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin = medecinRepository.findByNom("yassmina");

            Rendezvous rendezvous = new Rendezvous();
            rendezvous.setDate(new Date());
            rendezvous.setStatus(StatusRDV.PENDING);
            rendezvous.setMedecin(medecin);
            rendezvous.setPatient(patient);
            Rendezvous saveDRDV = hospitalService.saveRDV(rendezvous);
            System.out.println(saveDRDV.getId());
            Rendezvous rendezvous1 = rendezvousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezvous(rendezvous1);
            consultation.setRapport("rapport de la consultation......");
            hospitalService.saveConsultation(consultation);
        };

    }
}