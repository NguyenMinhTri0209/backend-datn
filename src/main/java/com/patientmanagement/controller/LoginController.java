package com.patientmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patientmanagement.dto.LoginRequest;
import com.patientmanagement.model.AdminPage;
import com.patientmanagement.model.Doctor;
import com.patientmanagement.model.Staff;
import com.patientmanagement.repository.AdminPageRepository;
import com.patientmanagement.repository.DoctorRepository;
import com.patientmanagement.repository.StaffRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private AdminPageRepository adminPageRepository;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
		
		AdminPage adminPage = adminPageRepository.findByTentkAndMatkhau(loginRequest.getTentk(), loginRequest.getMatkhau());
		if(adminPage != null)
			return new ResponseEntity<Object>(adminPage, HttpStatus.OK);
		
		Staff staff = staffRepository.findByTentkAndMatkhau(loginRequest.getTentk(), loginRequest.getMatkhau());
		if(staff != null)
			return new ResponseEntity<Object>(staff, HttpStatus.OK);
		
		Doctor doctor = doctorRepository.findByTentkAndMatkhau(loginRequest.getTentk(), loginRequest.getMatkhau());
		if(doctor != null)
			return new ResponseEntity<Object>(doctor, HttpStatus.OK);
		
		return new ResponseEntity<Object>("Invalid username or password", HttpStatus.UNAUTHORIZED);
	}
	
}
