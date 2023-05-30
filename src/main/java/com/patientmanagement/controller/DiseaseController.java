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

import com.patientmanagement.model.Disease;
import com.patientmanagement.service.IDiseaseService;

@RestController
@RequestMapping("/disease")
@CrossOrigin(origins = "http://localhost:3000")
public class DiseaseController {

	@Autowired
	private IDiseaseService iDiseaseService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Disease>> getAllDisease(){
		List<Disease> Disease = iDiseaseService.getAllDisease();
		return ResponseEntity.ok(Disease);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Disease> getById(@PathVariable String id){
		Disease Disease = iDiseaseService.getById(id);
		if(Disease != null)
			return ResponseEntity.ok(Disease);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Disease> save(@RequestBody Disease Disease){
		Disease Diseases = iDiseaseService.save(Disease);
		return ResponseEntity.status(HttpStatus.CREATED).body(Diseases);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Disease> update(@PathVariable String id, @RequestBody Disease Disease){
		Disease Diseases = iDiseaseService.updateDisease(id, Disease);
		if(Diseases != null) {
			return ResponseEntity.ok(Diseases);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Disease> delete(@PathVariable String id){
		boolean deleted = iDiseaseService.deleteDisease(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
