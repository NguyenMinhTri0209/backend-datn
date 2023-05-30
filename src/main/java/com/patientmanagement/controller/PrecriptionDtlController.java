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

import com.patientmanagement.dto.PresrcriptionDtoForColum;
import com.patientmanagement.model.Prescriptiondtl;
import com.patientmanagement.service.IPrescriptionDtlService;

@RestController
@RequestMapping("/prescriptiondtl")
@CrossOrigin(origins = "http://localhost:3000")
public class PrecriptionDtlController {
	
	@Autowired
	private IPrescriptionDtlService iPrescriptionDtlService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Prescriptiondtl>> getAllPrescriptiondtl(){
		List<Prescriptiondtl> Prescriptiondtl = iPrescriptionDtlService.getAllPrescriptiondtl();
		return ResponseEntity.ok(Prescriptiondtl);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Prescriptiondtl> getById(@PathVariable String id){
		Prescriptiondtl Prescriptiondtl = iPrescriptionDtlService.getById(id);
		if(Prescriptiondtl != null)
			return ResponseEntity.ok(Prescriptiondtl);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Prescriptiondtl> save(@RequestBody Prescriptiondtl Prescriptiondtl){
		Prescriptiondtl Prescriptiondtls = iPrescriptionDtlService.save(Prescriptiondtl);
		return ResponseEntity.status(HttpStatus.CREATED).body(Prescriptiondtls);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Prescriptiondtl> update(@PathVariable String id, @RequestBody Prescriptiondtl Prescriptiondtl){
		Prescriptiondtl Prescriptiondtls = iPrescriptionDtlService.updatePrescriptiondtl(id, Prescriptiondtl);
		if(Prescriptiondtls != null) {
			return ResponseEntity.ok(Prescriptiondtls);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Prescriptiondtl> delete(@PathVariable String id){
		boolean deleted = iPrescriptionDtlService.deletePrescriptiondtl(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/getbymaphieuthuoc/{maphieuthuoc}")
	public ResponseEntity<List<PresrcriptionDtoForColum>> findallbymaphieuthuoc(@PathVariable String maphieuthuoc){
		List<PresrcriptionDtoForColum> result = iPrescriptionDtlService.findByMaphieuthuoc(maphieuthuoc);
		return ResponseEntity.ok(result);
	} 
	
	@GetMapping("/laymactpn")
	public ResponseEntity<String> layma() {
	    String ma = iPrescriptionDtlService.getmactpn();
	    return ResponseEntity.ok(ma);
	}
	
}
