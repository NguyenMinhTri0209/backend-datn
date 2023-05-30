package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.RegisterService;
import com.patientmanagement.repository.RegisterServiceRepositry;
import com.patientmanagement.service.IRegisterServiceService;

@Service
public class ResigterServiceService implements IRegisterServiceService{
	
	@Autowired
	private RegisterServiceRepositry repositry;

	@Override
	public List<RegisterService> getAllRegisterService() {
		List<RegisterService> RegisterService = repositry.findAll();
		if(RegisterService.size() == 0)
			return null;
		else
			return RegisterService;
	}

	@Override
	public RegisterService getById(String id) {
		Optional<RegisterService> RegisterService = repositry.findById(id);
		if(RegisterService.isPresent())
			return RegisterService.get();
		else
			return null;
	}

	@Override
	public RegisterService save(RegisterService RegisterService) {
		if(RegisterService != null) {
			return repositry.save(RegisterService);
		}
		return null;
	}

	@Override
	public RegisterService updateRegisterService(String id, RegisterService RegisterService) {
		if(RegisterService != null){
			Optional<RegisterService> RegisterServiceTemp = repositry.findById(id);
			if(RegisterServiceTemp.isPresent()) {
				RegisterServiceTemp.get().setNgaykham(RegisterService.getNgaykham());
				RegisterServiceTemp.get().setMabn(RegisterService.getMabn());
				RegisterServiceTemp.get().setMabs(RegisterService.getMabs());
				RegisterServiceTemp.get().setMadvkham(RegisterService.getMadvkham());
				RegisterServiceTemp.get().setTinhtrang(RegisterService.isTinhtrang());
				RegisterServiceTemp.get().setGhichu(RegisterService.getGhichu());
				return repositry.save(RegisterServiceTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteRegisterService(String id) {
		Optional<RegisterService> RegisterService = repositry.findById(id);
		if(RegisterService.isPresent()) {
			repositry.delete(RegisterService.get());
			return true;
		}
		return false;
	}
	
}
