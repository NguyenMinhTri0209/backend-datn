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

import com.patientmanagement.model.GoodsReceiptDtl;
import com.patientmanagement.service.IGoodsReceiptDtlService;

@RestController
@RequestMapping("/goodsreiptdtl")
public class GoodsReicptDtlController {

	@Autowired
	private IGoodsReceiptDtlService iGoodsReceiptDtlService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<GoodsReceiptDtl>> getAll(){
		List<GoodsReceiptDtl> GoodsReceiptDtl = iGoodsReceiptDtlService.getAllGoodsReceiptDtl();
		return ResponseEntity.ok(GoodsReceiptDtl);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<GoodsReceiptDtl> getById(@PathVariable String id){
		GoodsReceiptDtl GoodsReceiptDtl = iGoodsReceiptDtlService.getById(id);
		if(GoodsReceiptDtl != null)
			return ResponseEntity.ok(GoodsReceiptDtl);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<GoodsReceiptDtl> save(@RequestBody GoodsReceiptDtl GoodsReceiptDtl){
		GoodsReceiptDtl GoodsReceiptDtls = iGoodsReceiptDtlService.save(GoodsReceiptDtl);
		return ResponseEntity.status(HttpStatus.CREATED).body(GoodsReceiptDtls);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<GoodsReceiptDtl> update(@PathVariable String id, @RequestBody GoodsReceiptDtl GoodsReceiptDtl){
		GoodsReceiptDtl GoodsReceiptDtls = iGoodsReceiptDtlService.updateGoodsReceiptDtl(id, GoodsReceiptDtl);
		if(GoodsReceiptDtls != null) {
			return ResponseEntity.ok(GoodsReceiptDtls);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GoodsReceiptDtl> delete(@PathVariable String id){
		boolean deleted = iGoodsReceiptDtlService.deleteGoodsReceiptDtl(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
}
