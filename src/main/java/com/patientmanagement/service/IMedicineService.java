package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.dto.MedicineDto;
import com.patientmanagement.model.Medicine;

public interface IMedicineService {

	//get all
	public List<Medicine> getAllMedicine();
	
	//get by id
	public Medicine getById(String id);
	
	//add
	public Medicine save(Medicine medicine);
	
	//update
	public Medicine updateMedicine(String id, Medicine medicine);
	
	//delete
	public boolean deleteMedicine(String id);
	
	//get chi tiet phieu thuoc
	public List<MedicineDto> getAllMedicineDto();
}
