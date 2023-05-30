package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.TofInsurance;
import com.patientmanagement.repository.TofInsuranceRepository;
import com.patientmanagement.service.ITofInsuranceService;

@Service
public class TofInsuranceService implements ITofInsuranceService{
	
	@Autowired
	private TofInsuranceRepository insuranceRepository;

	@Override
	public List<TofInsurance> getAllTofInsurance() {
		List<TofInsurance> TofInsurance = insuranceRepository.findAll();
		if(TofInsurance.size() == 0)
			return null;
		else
			return TofInsurance;
	}

	@Override
	public TofInsurance getById(String id) {
		Optional<TofInsurance> TofInsurance = insuranceRepository.findById(id);
		if(TofInsurance.isPresent())
			return TofInsurance.get();
		else
			return null;
	}

	@Override
	public TofInsurance save(TofInsurance TofInsurance) {
		if(TofInsurance != null) {
			return insuranceRepository.save(TofInsurance);
		}
		return null;
	}

	@Override
	public TofInsurance updateTofInsurance(String id, TofInsurance TofInsurance) {
		if(TofInsurance != null){
			Optional<TofInsurance> TofInsuranceTemp = insuranceRepository.findById(id);
			if(TofInsuranceTemp.isPresent()) {
				TofInsuranceTemp.get().setTenloaibh(TofInsurance.getTenloaibh());
				TofInsuranceTemp.get().setMuchuong(TofInsurance.getMuchuong());
				return insuranceRepository.save(TofInsuranceTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteTofInsurance(String id) {
		Optional<TofInsurance> TofInsurance = insuranceRepository.findById(id);
		if(TofInsurance.isPresent()) {
			insuranceRepository.delete(TofInsurance.get());
			return true;
		}
		return false;
	} 
	
}
