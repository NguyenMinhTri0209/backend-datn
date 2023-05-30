package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.TofService;

@Repository
public interface TofServiceRepository extends JpaRepository<TofService, String>{
	
}
