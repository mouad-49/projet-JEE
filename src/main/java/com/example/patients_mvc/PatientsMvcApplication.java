package com.example.patients_mvc;

import com.example.patients_mvc.entities.Patient;
import com.example.patients_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "mouad", new Date(), false, 12));
            patientRepository.save(new Patient(null, "yassine", new Date(), true, 120));
            patientRepository.save(new Patient(null, "jaafar", new Date(), true, 132));
            patientRepository.save(new Patient(null, "abderrhman", new Date(), false, 52));
            patientRepository.findAll().forEach(p -> System.out.println(p.getNom()));
        };
    }
}
