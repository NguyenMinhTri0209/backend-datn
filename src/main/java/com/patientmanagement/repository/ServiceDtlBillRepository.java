package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.ServiceDtlBill;
@Repository
public interface ServiceDtlBillRepository extends JpaRepository<ServiceDtlBill, String>{
	
	
}
