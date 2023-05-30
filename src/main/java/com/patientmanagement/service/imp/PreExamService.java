package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.PreExam;
import com.patientmanagement.repository.PreExamRepository;
import com.patientmanagement.service.IPreExamService;

@Service
public class PreExamService implements IPreExamService{

	@Autowired
	private PreExamRepository preExamRepository;
	
	//get all
	@Override
	public List<PreExam> getPreExam() {
		List<PreExam> PreExam = preExamRepository.findAll();
		if(PreExam.size() == 0)
			return null;
		else
			return PreExam;
	}

	//get by id
	@Override
	public PreExam getById(String id) {
		Optional<PreExam> PreExam = preExamRepository.findById(id);
		if(PreExam.isPresent())
			return PreExam.get();
		else
			return null;
	}

	//save
	@Override
	public PreExam save(PreExam PreExam) {
		if(PreExam != null) {
			return preExamRepository.save(PreExam);
		} 
		return null;
	}

	//update
	@Override
	public PreExam updatePreExam(String id, PreExam PreExam) {
		if(PreExam != null) {
			Optional<PreExam> PreExamTemp = preExamRepository.findById(id);
			if(PreExamTemp.isPresent()) {
				PreExamTemp.get().setNgaykham(PreExam.getNgaykham());
				PreExamTemp.get().setMabs(PreExam.getMabs());
				PreExamTemp.get().setMabn(PreExam.getMabn());
				PreExamTemp.get().setMabenh(PreExam.getMabenh());
				PreExamTemp.get().setCpkham(PreExam.getCpkham());
				return preExamRepository.save(PreExamTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deletePreExam(String id) {
		Optional<PreExam> PreExam = preExamRepository.findById(id);
		if(PreExam.isPresent()) {
			preExamRepository.delete(PreExam.get());
			return true;
		}
		return false;
	}
	
}
