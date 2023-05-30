package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Insurance;

public interface IInsuranceService {

	//get all
	public List<Insurance> getAllInsurance();

	//get by id
	public Insurance getById(String id);

	//add
	public Insurance save(Insurance Insurance);

	//update
	public Insurance updateInsurance(String id, Insurance Insurance);

	//delete
	public boolean deleteInsurance(String id);
	
}
