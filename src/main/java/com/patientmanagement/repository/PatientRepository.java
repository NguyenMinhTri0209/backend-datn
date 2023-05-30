package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{

}
