package com.patientmanagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String>{

	@Query("SELECT u FROM nhanvien u WHERE u.tentk = ?1 AND u.matkhau = ?2")
	Doctor findByTentkAndMatkhau(String tentk, String matkhau);
	
}
