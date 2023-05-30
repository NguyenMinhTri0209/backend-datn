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

import com.patientmanagement.dto.PTbnsd;
import com.patientmanagement.model.TestDtl;
import com.patientmanagement.service.ITestDtlService;

@RestController
@RequestMapping("/testdtl")
@CrossOrigin(origins = "http://localhost:3000")
public class TestDtlController {
	
	@Autowired
	private ITestDtlService iTestDtlService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<TestDtl>> getAll(){
		List<TestDtl> TestDtl = iTestDtlService.getAllTestDtl();
		return ResponseEntity.ok(TestDtl);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<TestDtl> getById(@PathVariable String id){
		TestDtl TestDtl = iTestDtlService.getById(id);
		if(TestDtl != null)
			return ResponseEntity.ok(TestDtl);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<TestDtl> save(@RequestBody TestDtl TestDtl){
		TestDtl TestDtls = iTestDtlService.save(TestDtl);
		return ResponseEntity.status(HttpStatus.CREATED).body(TestDtls);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<TestDtl> update(@PathVariable String id, @RequestBody TestDtl TestDtl){
		TestDtl TestDtls = iTestDtlService.updateTestDtl(id, TestDtl);
		if(TestDtl != null) {
			return ResponseEntity.ok(TestDtls);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TestDtl> delete(@PathVariable String id){
		boolean deleted = iTestDtlService.deleteTestDtl(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//get dv bn sd
	@GetMapping("/getptbn/{id}")
	public ResponseEntity<List<TestDtl>> getAllDv(@PathVariable String id) {
		List<TestDtl> Service = iTestDtlService.getalldvsd(id);
		return ResponseEntity.ok(Service);
	}
	
	
}
