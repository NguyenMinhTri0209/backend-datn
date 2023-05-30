package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.ServiceDtlBill;
import com.patientmanagement.repository.ServiceDtlBillRepository;
import com.patientmanagement.service.IServiceDtlBillService;

@Service
public class ServiceDtlBillService implements IServiceDtlBillService{

	@Autowired
	private ServiceDtlBillRepository billRepository;
	
	@Override
	public List<ServiceDtlBill> getAllServiceDtlBill() {
		List<ServiceDtlBill> ServiceDtlBill = billRepository.findAll();
		if(ServiceDtlBill.size() == 0)
			return null;
		else
			return ServiceDtlBill;
	}

	@Override
	public ServiceDtlBill getById(String id) {
		Optional<ServiceDtlBill> ServiceDtlBill = billRepository.findById(id);
		if(ServiceDtlBill.isPresent())
			return ServiceDtlBill.get();
		else
			return null;
	}

	@Override
	public ServiceDtlBill save(ServiceDtlBill ServiceDtlBill) {
		if(ServiceDtlBill != null) {
			return billRepository.save(ServiceDtlBill);
		}
		return null;
	}

	@Override
	public ServiceDtlBill updateServiceDtlBill(String id, ServiceDtlBill ServiceDtlBill) {
		if(ServiceDtlBill != null) {
			Optional<ServiceDtlBill> ServiceDtlBillTemp = billRepository.findById(id);
			if(ServiceDtlBillTemp.isPresent()) {
				ServiceDtlBillTemp.get().setMadvkham(ServiceDtlBill.getMadvkham());
				ServiceDtlBillTemp.get().setMadv(ServiceDtlBill.getMadv());
				ServiceDtlBillTemp.get().setSoluong(ServiceDtlBill.getSoluong());
				return billRepository.save(ServiceDtlBillTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteServiceDtlBill(String id) {
		Optional<ServiceDtlBill> ServiceDtlBill = billRepository.findById(id);
		if(ServiceDtlBill.isPresent()) {
			billRepository.delete(ServiceDtlBill.get());
			return true;
		}
		return false;
	}
	
}
