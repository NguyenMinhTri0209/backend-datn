package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Disease;

public interface IDiseaseService{

	//get all
	public List<Disease> getAllDisease();
	
	//get by id
	public Disease getById(String id);
	
	//add
	public Disease save(Disease disease);
	
	//update
	public Disease updateDisease(String id, Disease disease);
	
	//delete
	public boolean deleteDisease(String id);
	
}
