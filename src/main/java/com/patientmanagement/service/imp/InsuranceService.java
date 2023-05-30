package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Insurance;
import com.patientmanagement.repository.InsuranceRepository;
import com.patientmanagement.service.IInsuranceService;

@Service
public class InsuranceService implements IInsuranceService{
	
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public List<Insurance> getAllInsurance() {
		List<Insurance> Insurance = insuranceRepository.findAll();
		if(Insurance.size() == 0)
			return null;
		else
			return Insurance;
	}

	@Override
	public Insurance getById(String id) {
		Optional<Insurance> Insurance = insuranceRepository.findById(id);
		if(Insurance.isPresent())
			return Insurance.get();
		else
			return null;
	}

	@Override
	public Insurance save(Insurance Insurance) {
		if(Insurance != null) {
			return insuranceRepository.save(Insurance);
		}
		return null;
	}

	@Override
	public Insurance updateInsurance(String id, Insurance Insurance) {
		if(Insurance != null) {
			Optional<Insurance> InsuranceTemp = insuranceRepository.findById(id);
			if(InsuranceTemp.isPresent()) {
				InsuranceTemp.get().setMaloaibh(Insurance.getMaloaibh());
				InsuranceTemp.get().setNgaybatdaubh(Insurance.getNgaybatdaubh());
				InsuranceTemp.get().setNgaydongbh(Insurance.getNgaydongbh());
				InsuranceTemp.get().setNgayhethanbh(Insurance.getNgayhethanbh());
				InsuranceTemp.get().setDiadiemdk(Insurance.getDiadiemdk());
				return insuranceRepository.save(InsuranceTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteInsurance(String id) {
		Optional<Insurance> Insurance = insuranceRepository.findById(id);
		if(Insurance.isPresent()) {
			insuranceRepository.delete(Insurance.get());
			return true;
		}
		return false;
	}
	
	

}
