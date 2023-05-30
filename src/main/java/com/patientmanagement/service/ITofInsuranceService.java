package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.TofInsurance;

public interface ITofInsuranceService {
	
	//get all
	public List<TofInsurance> getAllTofInsurance();

	//get by id
	public TofInsurance getById(String id);

	//add
	public TofInsurance save(TofInsurance TofInsurance);

	//update
	public TofInsurance updateTofInsurance(String id, TofInsurance TofInsurance);

	//delete
	public boolean deleteTofInsurance(String id);
	
}
