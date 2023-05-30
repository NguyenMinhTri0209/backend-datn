package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.TofService;

public interface ITofServiceService {
	//get all
	public List<TofService> getAllTofService();
	
	//get by id
	public TofService getById(String id);
	
	//add
	public TofService save(TofService tofService);
	
	//update
	public TofService updateTofService(String id, TofService tofService);
	
	//delete
	public boolean deleteTofService(String id);
}
