package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Patient;

public interface IPatientService {
	
	//get all
	public List<Patient> getAllPatient();
	
	//get by id
	public Patient getById(String id);
	
	//add
	public Patient save(Patient Patient);
	
	//update
	public Patient updatePatient(String id, Patient patient);
	
	//delete
	public boolean deletePatient(String id);
}
