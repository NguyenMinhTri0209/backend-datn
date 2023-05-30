package com.patientmanagement.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.dto.PresrcriptionDtoForColum;
import com.patientmanagement.model.Medicine;
import com.patientmanagement.model.Prescription;
import com.patientmanagement.model.Prescriptiondtl;
import com.patientmanagement.repository.MedicineRepository;
import com.patientmanagement.repository.PrescriptionDtlRepository;
import com.patientmanagement.service.IPrescriptionDtlService;

@Service
public class PrescriptionDtlService implements IPrescriptionDtlService{

	@Autowired
	private PrescriptionDtlRepository prescriptionDtlRepository;

	//get all
	@Override
	public List<Prescriptiondtl> getAllPrescriptiondtl() {
		List<Prescriptiondtl> prescriptionDtl = prescriptionDtlRepository.findAll();
		if(prescriptionDtl.size() == 0)
			return null;
		else
			return prescriptionDtl;
	}

	//get by id
	@Override
	public Prescriptiondtl getById(String id) {
		Optional<Prescriptiondtl> prescriptionDtl = prescriptionDtlRepository.findById(id);
		if(prescriptionDtl.isPresent())
			return prescriptionDtl.get();
		else
			return null;
	}

	//save
	@Override
	public Prescriptiondtl save(Prescriptiondtl prescriptiondtl) {
		if(prescriptiondtl != null) {
			return prescriptionDtlRepository.save(prescriptiondtl);
		}
		return null;
	}

	//update
	@Override
	public Prescriptiondtl updatePrescriptiondtl(String id, Prescriptiondtl prescriptiondtl) {
		if(prescriptiondtl != null) {
			Optional<Prescriptiondtl> prescriptiondtlTemp = prescriptionDtlRepository.findById(id);
			if(prescriptiondtlTemp.isPresent()) {
				prescriptiondtlTemp.get().setMathuoc(prescriptiondtl.getMathuoc());
				prescriptiondtlTemp.get().setMathuoc(prescriptiondtl.getMathuoc());
				prescriptiondtlTemp.get().setSoluong(prescriptiondtl.getSoluong());
				return prescriptionDtlRepository.save(prescriptiondtlTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deletePrescriptiondtl(String id) {
		Optional<Prescriptiondtl> prescriptiondtl = prescriptionDtlRepository.findById(id);
		if(prescriptiondtl.isPresent()) {
			prescriptionDtlRepository.delete(prescriptiondtl.get());
			return true;
		}
		return false;
	}

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public List<PresrcriptionDtoForColum> findByMaphieuthuoc(String Maphieuthuoc) {
		List<Prescriptiondtl> resultsTemp = prescriptionDtlRepository.findAll();
		List<Prescriptiondtl> result = new ArrayList<>();
		for(Prescriptiondtl e : resultsTemp) {
			if(e.getMaphieuthuoc().compareTo(Maphieuthuoc) == 0) {
				result.add(e);
			}
		}
		List<Medicine> medicines = medicineRepository.findAll();
		List<PresrcriptionDtoForColum> resultFinal = new ArrayList<>();
		for(Prescriptiondtl e : result) {
			PresrcriptionDtoForColum temp = new PresrcriptionDtoForColum();
			temp.setMactpn(e.getMactpn());
			temp.setSoluong(e.getSoluong());
			temp.setMaphieuthuoc(e.getMaphieuthuoc());
			for(Medicine me : medicines ) {
				if(e.getMathuoc().compareTo(me.getMathuoc()) == 0) {
					temp.setTenThuoc(me.getTenthuoc());
				}
			}
			resultFinal.add(temp);
		}
		
		return resultFinal;
	}

	@Override
	public String getmactpn() {
		
		List<Prescriptiondtl> list = prescriptionDtlRepository.findAll();
		List<Long> listId = new ArrayList<>();

		for (Prescriptiondtl ls : list) {
		    String mactpn = ls.getMactpn();
		    String numberPart = mactpn.substring(mactpn.length() - 6);
		    long temp = Long.parseLong(numberPart);
		    listId.add(temp);
		}

		long max = 0;
		for (long num : listId) {
		    if (num > max) {
		        max = num;
		    }
		}

		long newNumber = max+1;
		String ma = String.format("CT%06d", newNumber);
		return ma;

	}
	
	

	
	
}
