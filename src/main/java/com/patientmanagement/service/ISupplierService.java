package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Supplier;


public interface ISupplierService {
	//get all
		public List<Supplier> getAllSupplier();
		
		//get by id
		public Supplier getById(String id);
		
		//add
		public Supplier save(Supplier supplier);
		
		//update
		public Supplier updateSupplier(String id, Supplier supplier);
		
		//delete
		public boolean deleteSupplier(String id);
}
