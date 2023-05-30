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

import com.patientmanagement.dto.MedicineDto;
import com.patientmanagement.model.Medicine;
import com.patientmanagement.service.IMedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicineController {
	
	@Autowired
	private IMedicineService iMedicineService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Medicine>> getAllMedicine(){
		List<Medicine> Medicine = iMedicineService.getAllMedicine();
		return ResponseEntity.ok(Medicine);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Medicine> getById(@PathVariable String id){
		Medicine Medicine = iMedicineService.getById(id);
		if(Medicine != null)
			return ResponseEntity.ok(Medicine);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Medicine> save(@RequestBody Medicine Medicine){
		Medicine Medicines = iMedicineService.save(Medicine);
		return ResponseEntity.status(HttpStatus.CREATED).body(Medicines);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> update(@PathVariable String id, @RequestBody Medicine Medicine){
		Medicine Medicines = iMedicineService.updateMedicine(id, Medicine);
		if(Medicines != null) {
			return ResponseEntity.ok(Medicines);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Medicine> delete(@PathVariable String id){
		boolean deleted = iMedicineService.deleteMedicine(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/getmediall")
	public ResponseEntity<List<MedicineDto>> getmeDiAll(){
		List<MedicineDto> list = iMedicineService.getAllMedicineDto();
		return ResponseEntity.ok(list);
	}
}
