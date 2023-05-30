package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.dto.custormPatientHsba;
import com.patientmanagement.model.HealthRecord;

public interface IHealthRecordService {

	//get all
	public List<HealthRecord> getAllHealthRecord();

	//get by id
	public HealthRecord getById(String id);

	//add
	public HealthRecord save(HealthRecord HealthRecord);

	//update
	public HealthRecord updateHealthRecord(String id, HealthRecord HealthRecord);

	//delete
	public boolean deleteHealthRecord(String id);
	
	//find all custom
	public List<custormPatientHsba> findallCustom();
	
}
