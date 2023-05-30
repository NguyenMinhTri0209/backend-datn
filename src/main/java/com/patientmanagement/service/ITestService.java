package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.Test;

public interface ITestService {
	
	//get all
	public List<Test> getAllTest();

	//get by id
	public Test getById(String id);

	//add
	public Test save(Test Test);

	//update
	public Test updateTest(String id, Test Test);

	//delete
	public boolean deleteTest(String id);
	
	

}
