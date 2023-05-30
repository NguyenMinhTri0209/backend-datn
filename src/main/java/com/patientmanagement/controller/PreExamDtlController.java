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

import com.patientmanagement.model.PreExamDtl;
import com.patientmanagement.service.IPreExamDtlService;

@RestController
@RequestMapping("/preexamdtl")
public class PreExamDtlController {
	
	@Autowired
	private IPreExamDtlService iPreExamDtlService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<PreExamDtl>> getAll(){
		List<PreExamDtl> PreExamDtl = iPreExamDtlService.getPreExamDtl();
		return ResponseEntity.ok(PreExamDtl);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<PreExamDtl> getById(@PathVariable String id){
		PreExamDtl PreExamDtl = iPreExamDtlService.getById(id);
		if(PreExamDtl != null)
			return ResponseEntity.ok(PreExamDtl);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<PreExamDtl> save(@RequestBody PreExamDtl PreExamDtl){
		PreExamDtl PreExamDtls = iPreExamDtlService.save(PreExamDtl);
		return ResponseEntity.status(HttpStatus.CREATED).body(PreExamDtls);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<PreExamDtl> update(@PathVariable String id, @RequestBody PreExamDtl PreExamDtl){
		PreExamDtl PreExamDtls = iPreExamDtlService.updatePreExamDtl(id, PreExamDtl);
		if(PreExamDtls != null) {
			return ResponseEntity.ok(PreExamDtls);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PreExamDtl> delete(@PathVariable String id){
		boolean deleted = iPreExamDtlService.deletePreExamDtl(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}	
