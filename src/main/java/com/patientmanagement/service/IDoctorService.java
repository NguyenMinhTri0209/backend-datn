package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Doctor;

public interface IDoctorService {

	//get all
	public List<Doctor> getAllDoctor();
	
	//get by id
	public Doctor getById(String id);
	
	//add
	public Doctor save(Doctor doctor);
	
	//update
	public Doctor updateDoctor(String id, Doctor doctor);
	
	//delete
	public boolean deleteDoctor(String id);
	
}
