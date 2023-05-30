package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.PreExamDtl;

public interface IPreExamDtlService {
	
	//get all
	public List<PreExamDtl> getPreExamDtl();
	
	//get by id
	public PreExamDtl getById(String id);
	
	//add
	public PreExamDtl save(PreExamDtl PreExamDtl);
	
	//update
	public PreExamDtl updatePreExamDtl(String id, PreExamDtl PreExamDtl);
	
	//delete
	public boolean deletePreExamDtl(String id);
	
}
