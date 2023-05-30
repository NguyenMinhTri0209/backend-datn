package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Department;
import com.patientmanagement.repository.DepartmentRepository;
import com.patientmanagement.service.IDepartmentService;

@Service
public class DeparmentService implements IDepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	//get all
	@Override
	public List<Department> getAllDepartment() {
		List<Department> departments = departmentRepository.findAll();
		if(departments.size() == 0)
			return null;
		else
			return departments;
	}

	//get by id
	@Override
	public Department getById(String id) {
		Optional<Department> departments = departmentRepository.findById(id);
		if(departments.isPresent())
			return departments.get();
		else
			return null;
	}

	//save
	@Override
	public Department save(Department department) {
		if(department != null) {
			return departmentRepository.save(department);
		}
		return null;
	}

	//update
	@Override
	public Department updateDepartment(String id, Department department) {
		if(department != null) {
			Optional<Department> departments = departmentRepository.findById(id);
			if(departments.isPresent()) {
				departments.get().setTenkhoa(department.getTenkhoa());
				departments.get().setChuyenmon(department.getChuyenmon());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteDepartment(String id) {
		Optional<Department> departments = departmentRepository.findById(id);
		if(departments.isPresent()) {
			departmentRepository.delete(departments.get());
			return true;
		}
		return false;
	}

}
