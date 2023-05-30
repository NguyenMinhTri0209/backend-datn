package com.patientmanagement.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.patientmanagement.dto.custormPatientHsba;
import com.patientmanagement.model.HealthRecord;
import com.patientmanagement.model.Insurance;
import com.patientmanagement.model.Patient;
import com.patientmanagement.repository.HealthRecordRepository;
import com.patientmanagement.repository.InsuranceRepository;
import com.patientmanagement.repository.PatientRepository;
import com.patientmanagement.service.IHealthRecordService;


@Service
public class HealthRecordService implements IHealthRecordService{

	@Autowired
	private HealthRecordRepository healthRecordRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Override
	public List<HealthRecord> getAllHealthRecord() {
		List<HealthRecord> HealthRecord = healthRecordRepository.findAll();
		if(HealthRecord.size() == 0)
			return null;
		else
			return HealthRecord;
	}

	@Override
	public HealthRecord getById(String id) {
		Optional<HealthRecord> HealthRecord = healthRecordRepository.findById(id);
		if(HealthRecord.isPresent())
			return HealthRecord.get();
		else
			return null;
	}

	@Override
	public HealthRecord save(HealthRecord HealthRecord) {
		if(HealthRecord != null) {
			return healthRecordRepository.save(HealthRecord);
		}
		return null;
	}

	@Override
	public HealthRecord updateHealthRecord(String id, HealthRecord HealthRecord) {
		if(HealthRecord != null) {
			Optional<HealthRecord> HealthRecordTemp = healthRecordRepository.findById(id);
			if(HealthRecordTemp.isPresent()) {
				HealthRecordTemp.get().setMabn(HealthRecord.getMabn());
				HealthRecordTemp.get().setMabs(HealthRecord.getMabs());
				HealthRecordTemp.get().setNgaybd(HealthRecord.getNgaykt());
				HealthRecordTemp.get().setCdravien(HealthRecord.getCdvaovien());
				HealthRecordTemp.get().setCdravien(HealthRecord.getCdravien());
				HealthRecordTemp.get().setTomtatba(HealthRecord.getTomtatba());
				HealthRecordTemp.get().setGhichu(HealthRecord.getGhichu());
				return healthRecordRepository.save(HealthRecordTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteHealthRecord(String id) {
		Optional<HealthRecord> HealthRecord = healthRecordRepository.findById(id);
		if(HealthRecord.isPresent()) {
			healthRecordRepository.delete(HealthRecord.get());
			return true;
		}
		return false;
	}

	@Override
	public List<custormPatientHsba> findallCustom() {
		List<custormPatientHsba> listCs = new ArrayList<>();
		
		List<HealthRecord> listHealthRecord = healthRecordRepository.findAll();
		for(HealthRecord h : listHealthRecord) {
			custormPatientHsba temp = new custormPatientHsba();
			temp.setMahsba(h.getMahsba());
			temp.setMabn(h.getMabn());
			temp.setMabs(h.getMabs());
			temp.setNgaybd(h.getNgaybd());
			temp.setNgaykt(h.getNgaykt());
			temp.setCdvaovien(h.getCdvaovien());
			temp.setCdravien(h.getCdravien());
			temp.setTomtatba(h.getTomtatba());
			temp.setGhichu(h.getGhichu());
			listCs.add(temp);
		}
		
		List<Patient> listPatient = patientRepository.findAll();
		
		for(custormPatientHsba cs : listCs) {
			for(Patient p : listPatient) {
				if(cs.getMabn().compareTo(p.getMabn()) == 0) {
					cs.setTen(p.getTen());
					cs.setGioitinh(p.isGioitinh());
					cs.setNgaysinh(p.getNgaysinh());
					cs.setMabhyt(p.getMabh());
				}
			}
		}
		
		for (int i = 0; i < listCs.size() - 1; i++) {
		    for (int j = i + 1; j < listCs.size(); j++) {
		        if (listCs.get(i).getMahsba().compareTo(listCs.get(j).getMahsba()) > 0) {
		            custormPatientHsba temp = listCs.get(i);
		            listCs.set(i, listCs.get(j));
		            listCs.set(j, temp);
		        }
		    }
		}
		
		return listCs;
	}

	

}
