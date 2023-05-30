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

import com.patientmanagement.model.ServiceDtlBill;
import com.patientmanagement.service.IServiceDtlBillService;

@RestController
@RequestMapping("/servicebilldtl")
public class ServiceBillDtlController {
	
	@Autowired
	private IServiceDtlBillService iServiceDtlBillService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<ServiceDtlBill>> getAll(){
		List<ServiceDtlBill> ServiceDtlBill = iServiceDtlBillService.getAllServiceDtlBill();
		return ResponseEntity.ok(ServiceDtlBill);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ServiceDtlBill> getById(@PathVariable String id){
		ServiceDtlBill ServiceDtlBill = iServiceDtlBillService.getById(id);
		if(ServiceDtlBill != null)
			return ResponseEntity.ok(ServiceDtlBill);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<ServiceDtlBill> save(@RequestBody ServiceDtlBill ServiceDtlBill){
		ServiceDtlBill ServiceDtlBills = iServiceDtlBillService.save(ServiceDtlBill);
		return ResponseEntity.status(HttpStatus.CREATED).body(ServiceDtlBills);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<ServiceDtlBill> update(@PathVariable String id, @RequestBody ServiceDtlBill ServiceDtlBill){
		ServiceDtlBill ServiceDtlBills = iServiceDtlBillService.updateServiceDtlBill(id, ServiceDtlBill);
		if(ServiceDtlBills != null) {
			return ResponseEntity.ok(ServiceDtlBills);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ServiceDtlBill> delete(@PathVariable String id){
		boolean deleted = iServiceDtlBillService.deleteServiceDtlBill(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
