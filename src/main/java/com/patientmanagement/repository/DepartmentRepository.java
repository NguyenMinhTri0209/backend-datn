package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

}
