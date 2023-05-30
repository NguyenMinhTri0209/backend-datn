package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Test;
@Repository
public interface TestRepository extends JpaRepository<Test, String>{
	
}
