package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.PreExam;
@Repository
public interface PreExamRepository extends JpaRepository<PreExam, String>{

}
