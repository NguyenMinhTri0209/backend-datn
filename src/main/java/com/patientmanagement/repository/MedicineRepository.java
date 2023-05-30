package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Medicine;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String>{

}
