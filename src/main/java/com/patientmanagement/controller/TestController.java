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

import com.patientmanagement.model.Test;
import com.patientmanagement.service.ITestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private ITestService iTestService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Test>> getAll(){
		List<Test> Test = iTestService.getAllTest();
		return ResponseEntity.ok(Test);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Test> getById(@PathVariable String id){
		Test Test = iTestService.getById(id);
		if(Test != null)
			return ResponseEntity.ok(Test);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<Test> save(@RequestBody Test Test){
		Test Tests = iTestService.save(Test);
		return ResponseEntity.status(HttpStatus.CREATED).body(Tests);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Test> update(@PathVariable String id, @RequestBody Test Test){
		Test Tests = iTestService.updateTest(id, Test);
		if(Tests != null) {
			return ResponseEntity.ok(Tests);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Test> delete(@PathVariable String id){
		boolean deleted = iTestService.deleteTest(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
