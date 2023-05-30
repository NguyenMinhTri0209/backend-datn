package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Insurance;
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String>{

}
