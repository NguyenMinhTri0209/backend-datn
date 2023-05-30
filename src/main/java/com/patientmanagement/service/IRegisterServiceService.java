package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.RegisterService;

public interface IRegisterServiceService {
	//get all
	public List<RegisterService> getAllRegisterService();

	//get by id
	public RegisterService getById(String id);

	//add
	public RegisterService save(RegisterService RegisterService);

	//update
	public RegisterService updateRegisterService(String id, RegisterService RegisterService);

	//delete
	public boolean deleteRegisterService(String id);
}
