package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Department;

public interface IDepartmentService {

	//get all
	public List<Department> getAllDepartment();
	
	//get by id
	public Department getById(String id);
	
	//add
	public Department save(Department department);
	
	//update
	public Department updateDepartment(String id, Department department);
	
	//delete
	public boolean deleteDepartment(String id);
	
}
