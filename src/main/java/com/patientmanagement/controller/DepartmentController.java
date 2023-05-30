package com.patientmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientmanagement.model.Department;
import com.patientmanagement.service.IDepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Department>> getAllDepartment(){
		List<Department> Departments = departmentService.getAllDepartment();
		return ResponseEntity.ok(Departments);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Department> getById(@PathVariable String id){
		Department Department = departmentService.getById(id);
		if(Department != null)
			return ResponseEntity.ok(Department);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Department> save(@RequestBody Department Department){
		Department Departments = departmentService.save(Department);
		return ResponseEntity.status(HttpStatus.CREATED).body(Departments);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Department> update(@PathVariable String id, @RequestBody Department Department){
		Department Departments = departmentService.updateDepartment(id, Department);
		if(Departments != null) {
			return ResponseEntity.ok(Departments);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Department> delete(@PathVariable String id){
		boolean deleted = departmentService.deleteDepartment(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
