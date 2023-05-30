package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.AdminPage;
import com.patientmanagement.repository.AdminPageRepository;
import com.patientmanagement.service.IAdminPageService;

@Service
public class AdminPageService implements IAdminPageService{

	@Autowired
	private AdminPageRepository adminPageRepository;
	
	//get all
	@Override
	public List<AdminPage> getAllAdminPage() {
		List<AdminPage> adminPages = adminPageRepository.findAll(); 
		if(adminPages.size() == 0)
			return null;
		else
			return adminPages;
	}

	//get by id
	@Override
	public AdminPage getById(String id) {
		Optional<AdminPage> AdminPages = adminPageRepository.findById(id);
		if(AdminPages.isPresent())
			return AdminPages.get();
		else
			return null;
	}

	//save
	@Override
	public AdminPage save(AdminPage adminPage) {
		if(adminPage != null)
			return adminPageRepository.save(adminPage);
		return null;
	}

	//update
	@Override
	public AdminPage updateAdminPage(String id, AdminPage adminPage) {
		if(adminPage != null) {
			Optional<AdminPage> adminPages = adminPageRepository.findById(id);
			if(adminPages.isPresent()) {
				adminPages.get().setTen(adminPage.getTen());
				adminPages.get().setMatkhau(adminPage.getMatkhau());
				adminPages.get().setQuyen(adminPage.getQuyen());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteAdminPage(String id) {
		Optional<AdminPage> adminPages = adminPageRepository.findById(id);
		if(adminPages.isPresent()) {
			adminPageRepository.delete(adminPages.get());
			return true;
		}
		return false;
	}

}
