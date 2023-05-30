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

import com.patientmanagement.dto.DVbnsd;
import com.patientmanagement.dto.PTbnsd;
import com.patientmanagement.model.Prescription;
import com.patientmanagement.service.IPreScriptionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/precription")
public class PrecriptionController {
	
	@Autowired
	private IPreScriptionService iPreScriptionService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Prescription>> getAllPrecription(){
		List<Prescription> PreScription = iPreScriptionService.getAllPrescription();
		return ResponseEntity.ok(PreScription);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Prescription> getById(@PathVariable String id){
		Prescription Prescription = iPreScriptionService.getById(id);
		if(Prescription != null)
			return ResponseEntity.ok(Prescription);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Prescription> save(@RequestBody Prescription Prescription){
		Prescription Prescriptions = iPreScriptionService.save(Prescription);
		return ResponseEntity.status(HttpStatus.CREATED).body(Prescriptions);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Prescription> update(@PathVariable String id, @RequestBody Prescription Prescription){
		Prescription Prescriptions = iPreScriptionService.updatePrescription(id, Prescription);
		if(Prescriptions != null) {
			return ResponseEntity.ok(Prescriptions);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Prescription> delete(@PathVariable String id){
		boolean deleted = iPreScriptionService.deletePrescription(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/layma")
	public ResponseEntity<String> layma() {
	    String ma = iPreScriptionService.layID();
	    return ResponseEntity.ok(ma);
	}
	
	//get dv bn sd
		@GetMapping("/getptbn/{id}")
		public ResponseEntity<List<PTbnsd>> getAllDv(@PathVariable String id){
			List<PTbnsd> Service = iPreScriptionService.getallpt(id);
			return ResponseEntity.ok(Service);
		}
}
