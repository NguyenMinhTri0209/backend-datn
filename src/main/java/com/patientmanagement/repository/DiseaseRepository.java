package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Disease;
@Repository
public interface DiseaseRepository extends JpaRepository<Disease, String>{

}
