package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Doctor;
import com.patientmanagement.repository.DoctorRepository;
import com.patientmanagement.service.IDoctorService;

@Service
public class DoctorService implements IDoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	//get all
	@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> doctors = doctorRepository.findAll();
		if(doctors.size() == 0)
			return null;
		else
			return doctors;
	}

	//get by id
	@Override
	public Doctor getById(String id) {
		Optional<Doctor> doctors = doctorRepository.findById(id);
		if(doctors.isPresent())
			return doctors.get();
		else
			return null;
	}

	//save
	@Override
	public Doctor save(Doctor doctor) {
		if(doctor != null) {
			return doctorRepository.save(doctor);
		}
		return null;
	}

	//update
	@Override
	public Doctor updateDoctor(String id, Doctor doctor) {
		if(doctor != null) {
			Optional<Doctor> doctors = doctorRepository.findById(id);
			if(doctors.isPresent()) {
				doctors.get().setMakhoa(doctor.getMakhoa());
				doctors.get().setTen(doctor.getTen());
				doctors.get().setDiachi(doctor.getDiachi());
				doctors.get().setSodienthoai(doctor.getSodienthoai());
				doctors.get().setGioitinh(doctor.isGioitinh());
				doctors.get().setNgaysinh(doctor.getNgaysinh());
				doctors.get().setTrinhdo(doctor.getTrinhdo());
				doctors.get().setChuyenmon(doctor.getChuyenmon());
				doctors.get().setChucvu(doctor.getChucvu());
				doctors.get().setTentk(doctor.getTentk());
				doctors.get().setMatkhau(doctor.getMatkhau());
				doctors.get().setQuyen(doctor.getQuyen());
				return doctorRepository.save(doctors.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteDoctor(String id) {
		Optional<Doctor> doctors = doctorRepository.findById(id);
		if(doctors.isPresent()) {
			doctorRepository.delete(doctors.get());
			return true;
		}
		return false;
	}

}
