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

import com.patientmanagement.model.TofInsurance;
import com.patientmanagement.service.ITofInsuranceService;

@RestController
@RequestMapping("/tofinsurace")
public class TofInsuraceController {
	
	@Autowired
	private ITofInsuranceService iTofInsuranceService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<TofInsurance>> getAll(){
		List<TofInsurance> TofInsurance = iTofInsuranceService.getAllTofInsurance();
		return ResponseEntity.ok(TofInsurance);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<TofInsurance> getById(@PathVariable String id){
		TofInsurance TofInsurance = iTofInsuranceService.getById(id);
		if(TofInsurance != null)
			return ResponseEntity.ok(TofInsurance);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<TofInsurance> save(@RequestBody TofInsurance TofInsurance){
		TofInsurance TofInsurances = iTofInsuranceService.save(TofInsurance);
		return ResponseEntity.status(HttpStatus.CREATED).body(TofInsurances);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<TofInsurance> update(@PathVariable String id, @RequestBody TofInsurance TofInsurance){
		TofInsurance TofInsurances = iTofInsuranceService.updateTofInsurance(id, TofInsurance);
		if(TofInsurances != null) {
			return ResponseEntity.ok(TofInsurances);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TofInsurance> delete(@PathVariable String id){
		boolean deleted = iTofInsuranceService.deleteTofInsurance(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
