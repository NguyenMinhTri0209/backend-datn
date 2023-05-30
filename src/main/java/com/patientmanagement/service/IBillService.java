package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.dto.BillAndPatient;
import com.patientmanagement.dto.TienWrapper;
import com.patientmanagement.model.Bill;

public interface IBillService {
	//get all
	public List<Bill> getAllBill();

	//get by id
	public Bill getById(String id);

	//add
	public Bill save(Bill Bill);

	//update
	public Bill updateBill(String id, Bill Bill);

	//delete
	public boolean deleteBill(String id);
	
	//get bill customer
	public List<BillAndPatient> findAllBAP();
	
	//get bill customer chu nop
	public List<BillAndPatient> findAllBAPCN();
	
	//tính tiền bệnh nhân
	public TienWrapper checkBill(String id);
	
	//xác nhận đã tính tiền 
	public Bill xacnhan(String id);
}
