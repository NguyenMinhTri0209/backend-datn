package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Staff;

public interface IStaffService {
	
	//get all
	public List<Staff> getAllStaff();

	//get by id
	public Staff getById(String id);

	//add
	public Staff save(Staff Staff);

	//update
	public Staff updateStaff(String id, Staff Staff);

	//delete
	public boolean deleteStaff(String id);
	
}
