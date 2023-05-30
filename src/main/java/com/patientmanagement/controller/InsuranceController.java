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

import com.patientmanagement.model.Insurance;
import com.patientmanagement.service.IInsuranceService;

@RestController
@RequestMapping("/insurance")
@CrossOrigin(origins = "http://localhost:3000")
public class InsuranceController {

	@Autowired
	private IInsuranceService iInsuranceService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Insurance>> getAll(){
		List<Insurance> Insurance = iInsuranceService.getAllInsurance();
		return ResponseEntity.ok(Insurance);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Insurance> getById(@PathVariable String id){
		Insurance Insurance = iInsuranceService.getById(id);
		if(Insurance != null)
			return ResponseEntity.ok(Insurance);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<Insurance> save(@RequestBody Insurance Insurance){
		Insurance Insurances = iInsuranceService.save(Insurance);
		return ResponseEntity.status(HttpStatus.CREATED).body(Insurances);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Insurance> update(@PathVariable String id, @RequestBody Insurance Insurance){
		Insurance Insurances = iInsuranceService.updateInsurance(id, Insurance);
		if(Insurances != null) {
			return ResponseEntity.ok(Insurances);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Insurance> delete(@PathVariable String id){
		boolean deleted = iInsuranceService.deleteInsurance(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
