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

import com.patientmanagement.model.Supplier;
import com.patientmanagement.service.ISupplierService;

@RestController
@RequestMapping("/supplier")

public class SupplierController {

	@Autowired
	private ISupplierService iSupplierService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Supplier>> getAllSupplier(){
		List<Supplier> Supplier = iSupplierService.getAllSupplier();
		return ResponseEntity.ok(Supplier);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Supplier> getById(@PathVariable String id){
		Supplier Supplier = iSupplierService.getById(id);
		if(Supplier != null)
			return ResponseEntity.ok(Supplier);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Supplier> save(@RequestBody Supplier Supplier){
		Supplier Suppliers = iSupplierService.save(Supplier);
		return ResponseEntity.status(HttpStatus.CREATED).body(Suppliers);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Supplier> update(@PathVariable String id, @RequestBody Supplier Supplier){
		Supplier Suppliers = iSupplierService.updateSupplier(id, Supplier);
		if(Suppliers != null) {
			return ResponseEntity.ok(Suppliers);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Supplier> delete(@PathVariable String id){
		boolean deleted = iSupplierService.deleteSupplier(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
