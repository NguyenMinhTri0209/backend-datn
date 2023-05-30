package com.patientmanagement.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.dto.MedicineDto;
import com.patientmanagement.model.Doctor;
import com.patientmanagement.model.Medicine;
import com.patientmanagement.model.Patient;
import com.patientmanagement.model.Prescription;
import com.patientmanagement.repository.DoctorRepository;
import com.patientmanagement.repository.MedicineRepository;
import com.patientmanagement.repository.PatientRepository;
import com.patientmanagement.repository.PrescriptionDtlRepository;
import com.patientmanagement.repository.PrescriptionRepository;
import com.patientmanagement.service.IMedicineService;

@Service
public class MedicineService implements IMedicineService{

	@Autowired
	private MedicineRepository medicineRepository;
	
	//get all
	@Override
	public List<Medicine> getAllMedicine() {
		List<Medicine> medicines = medicineRepository.findAll();
		if(medicines.size() == 0)
			return null;
		else
			return medicines;
	}

	//get by id
	@Override
	public Medicine getById(String id) {
		Optional<Medicine> medicines = medicineRepository.findById(id);
		if(medicines.isPresent())
			return medicines.get();
		else
			return null;
	}

	//save
	@Override
	public Medicine save(Medicine medicine) {
		if(medicine != null) {
			return medicineRepository.save(medicine);
		}
		return null;
	}

	//update
	@Override
	public Medicine updateMedicine(String id, Medicine medicine) {
		if(medicine != null) {
			Optional<Medicine> medicineTemp = medicineRepository.findById(id);
			if(medicineTemp.isPresent()) {
				medicineTemp.get().setTenthuoc(medicine.getTenthuoc());
				medicineTemp.get().setDongia(medicine.getDongia());
				medicineTemp.get().setDonvitinh(medicine.getDonvitinh());
				medicineTemp.get().setCachdung(medicine.getDonvitinh());
				medicineTemp.get().setThanhphan(medicine.getThanhphan());
				medicineTemp.get().setHansd(medicine.getHansd());
				medicineTemp.get().setHangsx(medicine.getHangsx());
				medicineTemp.get().setNgaysx(medicine.getNgaysx());
				return medicineRepository.save(medicineTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteMedicine(String id) {
		Optional<Medicine> medicines = medicineRepository.findById(id);
		if(medicines.isPresent()) {
			medicineRepository.delete(medicines.get());
			return true;
		}
		return false;
	}

	//get mã thuốc, chi tiết mã thuốc và tên thuốc
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private PrescriptionDtlRepository dtlRepository;
	
	@Autowired 
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public List<MedicineDto> getAllMedicineDto() {
		
		List<Prescription> listPre = prescriptionRepository.findAll();
		List<MedicineDto> listMedi = new ArrayList<>();
		
		for(Prescription pr : listPre) {
			MedicineDto temp = new MedicineDto();
			temp.setMaphieuthuoc(pr.getMaphieuthuoc());
			temp.setMabn(pr.getMabn());
			temp.setMabs(pr.getMabs());
			temp.setNgayxuatthuoc(pr.getNgayxuatthuoc());
			listMedi.add(temp);
		}
		
		List<Patient> listPa = patientRepository.findAll();
		for(Patient pa : listPa) {
			for(MedicineDto me : listMedi) {
				if(me.getMabn().compareTo(pa.getMabn()) == 0) {
					me.setTenbn(pa.getTen());
				}
			}
		}
		
		List<Doctor> listDo = doctorRepository.findAll();
		for(Doctor d : listDo) {
			for(MedicineDto me : listMedi) {
				if(me.getMabs().compareTo(d.getMabs()) == 0) {
					me.setTenbs(d.getTen());
				}
			}
		}
		
		return listMedi;
	}

	
	
	
}
