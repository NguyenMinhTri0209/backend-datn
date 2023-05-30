package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String>{

}
