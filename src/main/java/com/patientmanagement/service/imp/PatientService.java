package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Patient;
import com.patientmanagement.repository.PatientRepository;
import com.patientmanagement.service.IPatientService;

@Service
public class PatientService implements IPatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	//get all
	@Override
	public List<Patient> getAllPatient() {
		List<Patient> Patient = patientRepository.findAll();
		if(Patient.size() == 0)
			return null;
		else
			return Patient;
	}

	//get by id
	@Override
	public Patient getById(String id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if(patient.isPresent())
			return patient.get();
		else
			return null;
	}

	// save
	@Override
	public Patient save(Patient Patient) {
		if(Patient != null)
			return patientRepository.save(Patient);
		else
			return null;
	}

	//update
	@Override
	public Patient updatePatient(String id, Patient patient) {
		if(patient != null) {
			Optional<Patient> PatientTemp = patientRepository.findById(id);
			if(PatientTemp.isPresent()) {
				PatientTemp.get().setTen(patient.getTen());
				PatientTemp.get().setNgaysinh(patient.getNgaysinh());
				PatientTemp.get().setEmail(patient.getEmail());
				PatientTemp.get().setGioitinh(patient.isGioitinh());
				PatientTemp.get().setSodienthoai(patient.getSodienthoai());
				PatientTemp.get().setCccd(patient.getCccd());
				PatientTemp.get().setMabh(patient.getMabh());
				PatientTemp.get().setNghenghiep(patient.getNghenghiep());
				return patientRepository.save(PatientTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deletePatient(String id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if(patient.isPresent()) {
			patientRepository.delete(patient.get());
			return true;
		}
		return false;
			
		
	}

}
