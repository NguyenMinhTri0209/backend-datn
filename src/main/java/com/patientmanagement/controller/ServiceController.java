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
import com.patientmanagement.model.Service;
import com.patientmanagement.service.IServiceService;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {

	@Autowired
	private IServiceService iServiceService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Service>> getAll(){
		List<Service> Service = iServiceService.getAllService();
		return ResponseEntity.ok(Service);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Service> getById(@PathVariable String id){
		Service Service = iServiceService.getById(id);
		if(Service != null)
			return ResponseEntity.ok(Service);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<Service> save(@RequestBody Service Service){
		Service Services = iServiceService.save(Service);
		return ResponseEntity.status(HttpStatus.CREATED).body(Services);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Service> update(@PathVariable String id, @RequestBody Service Service){
		Service Services = iServiceService.updateService(id, Service);
		if(Services != null) {
			return ResponseEntity.ok(Services);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Service> delete(@PathVariable String id){
		boolean deleted = iServiceService.deleteService(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//get dv bn sd
	@GetMapping("/getdvbn/{id}")
	public ResponseEntity<List<DVbnsd>> getAllDv(@PathVariable String id){
		List<DVbnsd> Service = iServiceService.listdvbnsd(id);
		return ResponseEntity.ok(Service);
	}
	
}
