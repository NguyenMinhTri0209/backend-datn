package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Supplier;
import com.patientmanagement.repository.SupplierRepository;
import com.patientmanagement.service.ISupplierService;

@Service
public class SupplierService implements ISupplierService{

	@Autowired
	private SupplierRepository supplierRepository;
	
	//get all
	@Override
	public List<Supplier> getAllSupplier() {
		List<Supplier> suppliers = supplierRepository.findAll();
		if(suppliers.size() == 0)
			return null;
		else
			return suppliers;
	}

	//get by id
	@Override
	public Supplier getById(String id) {
		Optional<Supplier> Supplier = supplierRepository.findById(id);
		if(Supplier.isPresent())
			return Supplier.get();
		else
			return null;
	}

	//save
	@Override
	public Supplier save(Supplier supplier) {
		if(supplier != null) {
			return supplierRepository.save(supplier);
		}
		return null;
	}

	//update
	@Override
	public Supplier updateSupplier(String id, Supplier supplier) {
		if(supplier != null) {
			Optional<Supplier> suppliers = supplierRepository.findById(id);
			if(suppliers.isPresent()) {
				suppliers.get().setTenncc(supplier.getTenncc());
				suppliers.get().setDiachi(supplier.getDiachi());
				suppliers.get().setSodienthoai(supplier.getSodienthoai());
				suppliers.get().setEmail(supplier.getEmail());
				suppliers.get().setQuocgia(supplier.getQuocgia());
				return supplierRepository.save(suppliers.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteSupplier(String id) {
		Optional<Supplier> suppliers = supplierRepository.findById(id);
		if(suppliers.isPresent()) {
			supplierRepository.delete(suppliers.get());
			return true;
		}
		return false;
	}
	
}
