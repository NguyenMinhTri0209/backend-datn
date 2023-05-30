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

import com.patientmanagement.model.PreExam;
import com.patientmanagement.service.IPreExamService;

@RestController
@RequestMapping("/preexma")
public class PreExamController {
	
	@Autowired
	private IPreExamService iPreExamService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<PreExam>> getAllPreExam(){
		List<PreExam> PreExam = iPreExamService.getPreExam();
		return ResponseEntity.ok(PreExam);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<PreExam> getById(@PathVariable String id){
		PreExam PreExams = iPreExamService.getById(id);
		if(PreExams != null)
			return ResponseEntity.ok(PreExams);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<PreExam> save(@RequestBody PreExam PreExam){
		PreExam PreExams = iPreExamService.save(PreExam);
		return ResponseEntity.status(HttpStatus.CREATED).body(PreExams);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PreExam> update(@PathVariable String id, @RequestBody PreExam PreExam){
		PreExam PreExams = iPreExamService.updatePreExam(id, PreExam);
		if(PreExams != null) {
			return ResponseEntity.ok(PreExams);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PreExam> delete(@PathVariable String id){
		boolean deleted = iPreExamService.deletePreExam(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
