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

import com.patientmanagement.model.GoodsReceipt;
import com.patientmanagement.service.IGoodsReceiptService;

@RestController
@RequestMapping("/goodsrepeict")
public class GoodsRepeictController {

	@Autowired
	private IGoodsReceiptService iGoodsReceiptService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<GoodsReceipt>> getAll(){
		List<GoodsReceipt> GoodsReceipt = iGoodsReceiptService.getAllGoodsReceipt();
		return ResponseEntity.ok(GoodsReceipt);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<GoodsReceipt> getById(@PathVariable String id){
		GoodsReceipt GoodsReceipt = iGoodsReceiptService.getById(id);
		if(GoodsReceipt != null)
			return ResponseEntity.ok(GoodsReceipt);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<GoodsReceipt> save(@RequestBody GoodsReceipt GoodsReceipt){
		GoodsReceipt GoodsReceipts = iGoodsReceiptService.save(GoodsReceipt);
		return ResponseEntity.status(HttpStatus.CREATED).body(GoodsReceipts);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<GoodsReceipt> update(@PathVariable String id, @RequestBody GoodsReceipt GoodsReceipt){
		GoodsReceipt GoodsReceipts = iGoodsReceiptService.updateGoodsReceipt(id, GoodsReceipt);
		if(GoodsReceipts != null) {
			return ResponseEntity.ok(GoodsReceipts);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GoodsReceipt> delete(@PathVariable String id){
		boolean deleted = iGoodsReceiptService.deleteGoodsReceipt(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
