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

import com.patientmanagement.model.AdminPage;
import com.patientmanagement.service.IAdminPageService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminPageController {
	
	@Autowired
	private IAdminPageService iAdminPageService;
	
	//get all
	@GetMapping("/getall")
	public ResponseEntity<List<AdminPage>> getAllTofService(){
		List<AdminPage> adminPages = iAdminPageService.getAllAdminPage();
		return ResponseEntity.ok(adminPages);
	}
	
	//get by id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<AdminPage> getById(@PathVariable String id){
		AdminPage adminPage = iAdminPageService.getById(id);
		if(adminPage != null)
			return ResponseEntity.ok(adminPage);
		else
			return ResponseEntity.notFound().build();
	}
	
	//save
	@PostMapping("/save")
	public ResponseEntity<AdminPage> save(@RequestBody AdminPage adminPage){
		AdminPage adminPages = iAdminPageService.save(adminPage);
		return ResponseEntity.status(HttpStatus.CREATED).body(adminPages);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<AdminPage> update(@PathVariable String id, @RequestBody AdminPage adminPage){
		AdminPage adminPages = iAdminPageService.updateAdminPage(id, adminPage);
		if(adminPages != null) {
			return ResponseEntity.ok(adminPages);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AdminPage> delete(@PathVariable String id){
		boolean deleted = iAdminPageService.deleteAdminPage(id);
	    if (deleted) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
