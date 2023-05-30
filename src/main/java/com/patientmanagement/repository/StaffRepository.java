package com.patientmanagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{

	@Query("SELECT u FROM nhanvien u WHERE u.tentk = ?1 AND u.matkhau = ?2")
	Staff findByTentkAndMatkhau(String tentk, String matkhau);
	
}
