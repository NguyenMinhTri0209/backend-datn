package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Staff;
import com.patientmanagement.repository.StaffRepository;
import com.patientmanagement.service.IStaffService;

@Service
public class StaffService implements IStaffService{

	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public List<Staff> getAllStaff() {
		List<Staff> Staff = staffRepository.findAll();
		if(Staff.size() == 0)
			return null;
		else
			return Staff;
	}

	@Override
	public Staff getById(String id) {
		Optional<Staff> Staff = staffRepository.findById(id);
		if(Staff.isPresent())
			return Staff.get();
		else
			return null;
	}

	@Override
	public Staff save(Staff Staff) {
		if(Staff != null) {
			return staffRepository.save(Staff);
		}
		return null;
	}

	@Override
	public Staff updateStaff(String id, Staff Staff) {
		if(Staff != null) {
			Optional<Staff> StaffTemp = staffRepository.findById(id);
			if(StaffTemp.isPresent()) {
				StaffTemp.get().setTen(Staff.getTen());
				StaffTemp.get().setNgaysinh(Staff.getNgaysinh());
				StaffTemp.get().setDiachi(Staff.getDiachi());
				StaffTemp.get().setGioitinh(Staff.isGioitinh());
				StaffTemp.get().setChucvu(Staff.getSodienthoai());
				StaffTemp.get().setTentk(Staff.getTentk());
				StaffTemp.get().setMatkhau(Staff.getMatkhau());
				StaffTemp.get().setQuyen(Staff.getQuyen());
				return staffRepository.save(StaffTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteStaff(String id) {
		Optional<Staff> Staff = staffRepository.findById(id);
		if(Staff.isPresent()) {
			staffRepository.delete(Staff.get());
			return true;
		}
		return false;
	}
	
}
