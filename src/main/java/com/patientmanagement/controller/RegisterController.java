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

import com.patientmanagement.model.RegisterService;
import com.patientmanagement.service.IRegisterServiceService;

@RestController
@RequestMapping("/registerservice")
public class RegisterController {
	
	@Autowired
	private IRegisterServiceService iRegisterServiceService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<RegisterService>> getAll(){
		List<RegisterService> RegisterService = iRegisterServiceService.getAllRegisterService();
		return ResponseEntity.ok(RegisterService);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<RegisterService> getById(@PathVariable String id){
		RegisterService RegisterService = iRegisterServiceService.getById(id);
		if(RegisterService != null)
			return ResponseEntity.ok(RegisterService);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<RegisterService> save(@RequestBody RegisterService RegisterService){
		RegisterService RegisterServices = iRegisterServiceService.save(RegisterService);
		return ResponseEntity.status(HttpStatus.CREATED).body(RegisterServices);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<RegisterService> update(@PathVariable String id, @RequestBody RegisterService RegisterService){
		RegisterService RegisterServices = iRegisterServiceService.updateRegisterService(id, RegisterService);
		if(RegisterServices != null) {
			return ResponseEntity.ok(RegisterServices);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<RegisterService> delete(@PathVariable String id){
		boolean deleted = iRegisterServiceService.deleteRegisterService(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
