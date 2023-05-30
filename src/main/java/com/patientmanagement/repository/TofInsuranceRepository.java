package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.TofInsurance;
@Repository
public interface TofInsuranceRepository extends JpaRepository<TofInsurance, String>{

}
