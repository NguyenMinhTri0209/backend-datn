package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.AdminPage;

public interface IAdminPageService {
	//get all
	public List<AdminPage> getAllAdminPage();
	
	//get by id
	public AdminPage getById(String id);
	
	//add
	public AdminPage save(AdminPage adminPage);
	
	//update
	public AdminPage updateAdminPage(String id, AdminPage adminPage);
	
	//delete
	public boolean deleteAdminPage(String id);
	
}
