package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.RegisterService;

@Repository
public interface RegisterServiceRepositry extends JpaRepository<RegisterService, String>{

}
