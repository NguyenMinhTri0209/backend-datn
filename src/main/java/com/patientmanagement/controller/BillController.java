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

import com.patientmanagement.dto.BillAndPatient;
import com.patientmanagement.dto.TienWrapper;
import com.patientmanagement.model.Bill;
import com.patientmanagement.model.Patient;
import com.patientmanagement.service.IBillService;
import com.patientmanagement.service.IPatientService;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins = "http://localhost:3000")
public class BillController {

	@Autowired
	private IBillService IBillService;
	
	@Autowired
	private IPatientService iPatientService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Bill>> getAll(){
		List<Bill> Bill = IBillService.getAllBill();
		return ResponseEntity.ok(Bill);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Bill> getById(@PathVariable String id){
		Bill Bill = IBillService.getById(id);
		if(Bill != null)
			return ResponseEntity.ok(Bill);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<Bill> save(@RequestBody Bill Bill){
		Bill Bills = IBillService.save(Bill);
		return ResponseEntity.status(HttpStatus.CREATED).body(Bills);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Bill> update(@PathVariable String id, @RequestBody Bill Bill){
		Bill Bills = IBillService.updateBill(id, Bill);
		if(Bills != null) {
			return ResponseEntity.ok(Bills);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Bill> delete(@PathVariable String id){
		boolean deleted = IBillService.deleteBill(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//getallcustomer
	@GetMapping("/getallcs")
	public ResponseEntity<List<BillAndPatient>> getAllcs(){
		List<BillAndPatient> Bill = IBillService.findAllBAP();
		return ResponseEntity.ok(Bill);
	}
	
	@GetMapping("/getallcscn")
	public ResponseEntity<List<BillAndPatient>> getAllcscn(){
		List<BillAndPatient> Bill = IBillService.findAllBAPCN();
		return ResponseEntity.ok(Bill);
	}
	
	@GetMapping("/chechbill/{id}")
	public ResponseEntity<TienWrapper> checkBill(@PathVariable String id){
		TienWrapper result = IBillService.checkBill(id);
		return ResponseEntity.ok(result);
	} 
	
	@GetMapping("/xacnhan/{id}")
	public Bill xacnhan(@PathVariable String id){
		Bill b = IBillService.xacnhan(id);
		return b;
	}
	
}
