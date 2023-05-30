package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.TofService;
import com.patientmanagement.repository.TofServiceRepository;
import com.patientmanagement.service.ITofServiceService;

@Service
public class TofServiceService implements ITofServiceService{

	@Autowired
	private TofServiceRepository tofServiceRepository;
	
	// get all
	@Override
	public List<TofService> getAllTofService() {
		List<TofService> tofService = tofServiceRepository.findAll();
		if(tofService.size() == 0)
			return null;
		else
			return tofService;
	}

	//get by id
	@Override
	public TofService getById(String id) {
		Optional<TofService> tofService = tofServiceRepository.findById(id);
		if(tofService.isPresent())
			return tofService.get();
		else
			return null;
	}

	//save
	@Override
	public TofService save(TofService tofService) {
		if(tofService != null) {
			return tofServiceRepository.save(tofService);
		}
		return null;
	}

	//update
	@Override
	public TofService updateTofService(String id, TofService tofService) {
		if(tofService != null) {
			Optional<TofService> tofServiceTemp = tofServiceRepository.findById(id);
			if(tofServiceTemp.isPresent()) {
				tofServiceTemp.get().setTendv(tofService.getTendv());
				tofServiceTemp.get().setApdungmh(tofService.isApdungmh());
				tofServiceTemp.get().setDongia(tofService.getDongia());
				return tofServiceRepository.save(tofServiceTemp.get());
			}
		}
		return null;
	}
	
	//delete
	@Override
	public boolean deleteTofService(String id) {
		Optional<TofService> tofService = tofServiceRepository.findById(id);
		if(tofService.isPresent()) {
			tofServiceRepository.delete(tofService.get());
			return true;
		}
		return false;
	}
	
}
