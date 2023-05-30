package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.dto.DVbnsd;
import com.patientmanagement.model.Service;

public interface IServiceService {

	//get all
	public List<Service> getAllService();

	//get by id
	public Service getById(String id);

	//add
	public Service save(Service Service);

	//update
	public Service updateService(String id, Service Service);

	//delete
	public boolean deleteService(String id);
	
	//dv bn sd
	public List<DVbnsd> listdvbnsd(String id);
}
