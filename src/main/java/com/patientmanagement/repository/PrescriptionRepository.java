package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, String>{

}
