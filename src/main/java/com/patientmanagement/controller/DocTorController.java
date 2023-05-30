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

import com.patientmanagement.model.Doctor;
import com.patientmanagement.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:3000")
public class DocTorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Doctor>> getAllTofDoctor(){
		List<Doctor> Doctors = doctorService.getAllDoctor();
		return ResponseEntity.ok(Doctors);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Doctor> getById(@PathVariable String id){
		Doctor Doctor = doctorService.getById(id);
		if(Doctor != null)
			return ResponseEntity.ok(Doctor);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Doctor> save(@RequestBody Doctor Doctor){
		Doctor Doctors = doctorService.save(Doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(Doctors);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Doctor> update(@PathVariable String id, @RequestBody Doctor Doctor){
		Doctor Doctors = doctorService.updateDoctor(id, Doctor);
		if(Doctors != null) {
			return ResponseEntity.ok(Doctors);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Doctor> delete(@PathVariable String id){
		boolean deleted = doctorService.deleteDoctor(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
