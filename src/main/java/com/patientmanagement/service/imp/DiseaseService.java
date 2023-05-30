package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Disease;
import com.patientmanagement.repository.DiseaseRepository;
import com.patientmanagement.service.IDiseaseService;

@Service
public class DiseaseService implements IDiseaseService{

	@Autowired
	private DiseaseRepository diseaseRepository;
	
	//get all
	@Override
	public List<Disease> getAllDisease() {
		List<Disease> disease = diseaseRepository.findAll();
		if(disease.size() == 0)
			return null;
		else
			return disease;
	}

	//get by id
	@Override
	public Disease getById(String id) {
		Optional<Disease> disease = diseaseRepository.findById(id);
		if(disease.isPresent())
			return disease.get();
		else
			return null;
	}

	//save
	@Override
	public Disease save(Disease disease) {
		if(disease != null) {
			return diseaseRepository.save(disease);
		}
		return null;
	}

	//update
	@Override
	public Disease updateDisease(String id, Disease disease) {
		if(disease != null) {
			Optional<Disease> diseaseTemp = diseaseRepository.findById(id);
			if(diseaseTemp.isPresent()) {
				diseaseTemp.get().setTenbenh(disease.getTenbenh());
				diseaseTemp.get().setTrieuchung(disease.getTrieuchung());
				return diseaseRepository.save(diseaseTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteDisease(String id) {
		Optional<Disease> disease = diseaseRepository.findById(id);
		if(disease.isPresent()) {
			diseaseRepository.delete(disease.get());
			return true;
		}
		return false;
	}

	
	
}
