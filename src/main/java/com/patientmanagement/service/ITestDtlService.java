package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.TestDtl;

public interface ITestDtlService {
	
	//get all
	public List<TestDtl> getAllTestDtl();
	
	//get by id
	public TestDtl getById(String id);
	
	//add
	public TestDtl save(TestDtl TestDtl);
	
	//update
	public TestDtl updateTestDtl(String id, TestDtl TestDtl);
	
	//delete
	public boolean deleteTestDtl(String id);
	
	//bill 
	public List<TestDtl> getalldvsd (String id);
	
}
