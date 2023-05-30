package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service, String>{

}
