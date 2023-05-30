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

import com.patientmanagement.dto.custormPatientHsba;
import com.patientmanagement.model.HealthRecord;
import com.patientmanagement.service.IHealthRecordService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/healthrecord")
public class HealthRecordController {

	@Autowired
	private IHealthRecordService iHealthRecordService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<HealthRecord>> getAll(){
		List<HealthRecord> HealthRecord = iHealthRecordService.getAllHealthRecord();
		return ResponseEntity.ok(HealthRecord);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<HealthRecord> getById(@PathVariable String id){
		HealthRecord HealthRecord = iHealthRecordService.getById(id);
		if(HealthRecord != null)
			return ResponseEntity.ok(HealthRecord);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<HealthRecord> save(@RequestBody HealthRecord HealthRecord){
		HealthRecord HealthRecords = iHealthRecordService.save(HealthRecord);
		return ResponseEntity.status(HttpStatus.CREATED).body(HealthRecords);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<HealthRecord> update(@PathVariable String id, @RequestBody HealthRecord HealthRecord){
		HealthRecord HealthRecords = iHealthRecordService.updateHealthRecord(id, HealthRecord);
		if(HealthRecords != null) {
			return ResponseEntity.ok(HealthRecords);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HealthRecord> delete(@PathVariable String id){
		boolean deleted = iHealthRecordService.deleteHealthRecord(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//đưa ra hồ sơ bệnh án cho bác sĩ
	@GetMapping("/getallhsba")
	public ResponseEntity<List<custormPatientHsba>> getallhsba(){
		List<custormPatientHsba> list = iHealthRecordService.findallCustom();
		return ResponseEntity.ok(list);
	}
	
}
