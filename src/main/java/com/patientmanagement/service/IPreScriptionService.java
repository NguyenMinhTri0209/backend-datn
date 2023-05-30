package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.dto.PTbnsd;
import com.patientmanagement.model.Prescription;

public interface IPreScriptionService {
	//get all
	public List<Prescription> getAllPrescription();
	
	//get by id
	public Prescription getById(String id);
	
	//add
	public Prescription save(Prescription prescription);
	
	//update
	public Prescription updatePrescription(String id, Prescription prescription);
	
	//delete
	public boolean deletePrescription(String id);
	
	//lay id
	public String layID();
	
	//phieu thuoc
	public List<PTbnsd> getallpt(String id);
}
