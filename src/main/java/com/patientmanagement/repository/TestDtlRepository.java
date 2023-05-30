package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.TestDtl;
@Repository
public interface TestDtlRepository  extends JpaRepository<TestDtl, String>{

}
