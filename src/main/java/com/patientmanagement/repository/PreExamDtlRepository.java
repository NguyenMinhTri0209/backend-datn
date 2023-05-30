package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.PreExamDtl;
@Repository
public interface PreExamDtlRepository extends JpaRepository<PreExamDtl, String>{
	
}
