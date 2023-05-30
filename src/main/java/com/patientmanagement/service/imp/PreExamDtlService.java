package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.PreExamDtl;
import com.patientmanagement.repository.PreExamDtlRepository;
import com.patientmanagement.service.IPreExamDtlService;

@Service
public class PreExamDtlService implements IPreExamDtlService{

	@Autowired
	private PreExamDtlRepository examDtlRepository;
	
	//get all
	@Override
	public List<PreExamDtl> getPreExamDtl() {
		List<PreExamDtl> PreExamDtl = examDtlRepository.findAll();
		if(PreExamDtl.size() == 0)
			return null;
		else
			return PreExamDtl;
	}

	//get by id
	@Override
	public PreExamDtl getById(String id) {
		Optional<PreExamDtl> PreExamDtl = examDtlRepository.findById(id);
		if(PreExamDtl.isPresent())
			return PreExamDtl.get();
		else
			return null;
	}

	//save
	@Override
	public PreExamDtl save(PreExamDtl PreExamDtl) {
		if(PreExamDtl != null) {
			return examDtlRepository.save(PreExamDtl);
		}
		return null;
	}

	//update
	@Override
	public PreExamDtl updatePreExamDtl(String id, PreExamDtl PreExamDtl) {
		if(PreExamDtl != null) {
			Optional<PreExamDtl> PreExamDtlTemp = examDtlRepository.findById(id);
			if(PreExamDtlTemp.isPresent()) {
				PreExamDtlTemp.get().setMabenh(PreExamDtl.getMabenh());
				return examDtlRepository.save(PreExamDtlTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deletePreExamDtl(String id) {
		Optional<PreExamDtl> PreExamDtl = examDtlRepository.findById(id);
		if(PreExamDtl.isPresent()) {
			examDtlRepository.delete(PreExamDtl.get());
			return true;
		}
		return false;
	}
	
}
