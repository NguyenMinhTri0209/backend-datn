package com.patientmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, String>{


}
