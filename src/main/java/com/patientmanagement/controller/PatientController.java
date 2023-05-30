package com.patientmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientmanagement.model.Doctor;
import com.patientmanagement.model.Patient;
import com.patientmanagement.service.IPatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
	
	@Autowired
	private IPatientService iPatientService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Patient>> getAllTofService(){
		List<Patient> patiens = iPatientService.getAllPatient();
		return ResponseEntity.ok(patiens);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Patient> getById(@PathVariable String id){
		Patient Patient = iPatientService.getById(id);
		if(Patient != null)
			return ResponseEntity.ok(Patient);
		else
			return ResponseEntity.notFound().build();
	}
}
