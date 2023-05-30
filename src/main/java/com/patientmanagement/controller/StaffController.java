package com.patientmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientmanagement.model.Staff;
import com.patientmanagement.service.IStaffService;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {

	@Autowired
	private IStaffService iStaffService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Staff>> getAll(){
		List<Staff> Staff = iStaffService.getAllStaff();
		return ResponseEntity.ok(Staff);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Staff> getById(@PathVariable String id){
		Staff Staff = iStaffService.getById(id);
		if(Staff != null)
			return ResponseEntity.ok(Staff);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<Staff> save(@RequestBody Staff Staff){
		Staff Staffs = iStaffService.save(Staff);
		return ResponseEntity.status(HttpStatus.CREATED).body(Staffs);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Staff> update(@PathVariable String id, @RequestBody Staff Staff){
		Staff Staffs = iStaffService.updateStaff(id, Staff);
		if(Staffs != null) {
			return ResponseEntity.ok(Staffs);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Staff> delete(@PathVariable String id){
		boolean deleted = iStaffService.deleteStaff(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
