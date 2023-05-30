package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.ServiceDtlBill;

public interface IServiceDtlBillService {
	//get all
	public List<ServiceDtlBill> getAllServiceDtlBill();

	//get by id
	public ServiceDtlBill getById(String id);

	//add
	public ServiceDtlBill save(ServiceDtlBill ServiceDtlBill);

	//update
	public ServiceDtlBill updateServiceDtlBill(String id, ServiceDtlBill ServiceDtlBill);

	//delete
	public boolean deleteServiceDtlBill(String id);
	
	//get list ServiceDtlBill
}
