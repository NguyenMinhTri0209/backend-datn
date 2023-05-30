package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.PreExam;

public interface IPreExamService {
	
	//get all
	public List<PreExam> getPreExam();
	
	//get by id
	public PreExam getById(String id);
	
	//add
	public PreExam save(PreExam PreExam);
	
	//update
	public PreExam updatePreExam(String id, PreExam PreExam);
	
	//delete
	public boolean deletePreExam(String id);
	
}
