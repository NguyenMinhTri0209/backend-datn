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

import com.patientmanagement.model.TofService;
import com.patientmanagement.service.ITofServiceService;

@CrossOrigin(origins = {"http://localhost:3001","http://localhost:3000"})
@RestController
@RequestMapping("/tofservice")
public class TofServiceController {
	
	@Autowired
	private ITofServiceService tofServiceService;
	
	//get all
	@GetMapping("/getall")
	public ResponseEntity<List<TofService>> getAllTofService(){
		List<TofService> tofServices = tofServiceService.getAllTofService();
		return ResponseEntity.ok(tofServices);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<TofService> getById(@PathVariable String id){
		TofService tofService = tofServiceService.getById(id);
		if(tofService != null)
			return ResponseEntity.ok(tofService);
		else
			return ResponseEntity.notFound().build();
	}

	//save
	@PostMapping("/save")
	public ResponseEntity<TofService> save(@RequestBody TofService tofService){
		TofService tofService1 = tofServiceService.save(tofService);
		return ResponseEntity.status(HttpStatus.CREATED).body(tofService1);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<TofService> update(@PathVariable String id, @RequestBody TofService tofService){
		TofService tofService1 = tofServiceService.updateTofService(id, tofService);
		if(tofService1 != null) {
			return ResponseEntity.ok(tofService1);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TofService> delete(@PathVariable String id){
		boolean deleted = tofServiceService.deleteTofService(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}	
