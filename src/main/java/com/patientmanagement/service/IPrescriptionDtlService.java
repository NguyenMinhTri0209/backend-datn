package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.dto.PresrcriptionDtoForColum;
import com.patientmanagement.model.Prescriptiondtl;

public interface IPrescriptionDtlService {

	//get all
	public List<Prescriptiondtl> getAllPrescriptiondtl();
	
	//get by id
	public Prescriptiondtl getById(String id);
	
	//add
	public Prescriptiondtl save(Prescriptiondtl prescriptiondtl);
	
	//update
	public Prescriptiondtl updatePrescriptiondtl(String id, Prescriptiondtl prescriptiondtl);
	
	//delete
	public boolean deletePrescriptiondtl(String id);
	
	
	//FIND BY MAPHIEUTHUOC
	public List<PresrcriptionDtoForColum> findByMaphieuthuoc(String Maphieuthuoc); 
	
	//lấy mã cton
	public String getmactpn();
	
}
