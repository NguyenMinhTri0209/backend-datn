package com.patientmanagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.AdminPage;

@Repository
public interface AdminPageRepository extends JpaRepository<AdminPage, String>{
	
	@Query("SELECT u FROM quantrivien u WHERE u.tentk = ?1 AND u.matkhau = ?2")
	AdminPage findByTentkAndMatkhau(String tentk, String matkhau);
	
}	
