package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.GoodsReceiptDtl;
import com.patientmanagement.repository.GoodsRepeictDtlRepository;
import com.patientmanagement.service.IGoodsReceiptDtlService;

@Service
public class GoodsReceiptDtlService implements IGoodsReceiptDtlService{
	
	@Autowired
	private GoodsRepeictDtlRepository repository;

	@Override
	public List<GoodsReceiptDtl> getAllGoodsReceiptDtl() {
		List<GoodsReceiptDtl> GoodsReceiptDtl = repository.findAll();
		if(GoodsReceiptDtl.size() == 0)
			return null;
		else
			return GoodsReceiptDtl;
	}

	@Override
	public GoodsReceiptDtl getById(String id) {
		Optional<GoodsReceiptDtl> GoodsReceiptDtl = repository.findById(id);
		if(GoodsReceiptDtl.isPresent())
			return GoodsReceiptDtl.get();
		else
			return null;
	}

	@Override
	public GoodsReceiptDtl save(GoodsReceiptDtl GoodsReceiptDtl) {
		if(GoodsReceiptDtl != null) {
			return repository.save(GoodsReceiptDtl);
		}
		return null;
	}

	@Override
	public GoodsReceiptDtl updateGoodsReceiptDtl(String id, GoodsReceiptDtl GoodsReceiptDtl) {
		if(GoodsReceiptDtl != null){
			Optional<GoodsReceiptDtl> GoodsReceiptDtlTemp = repository.findById(id);
			if(GoodsReceiptDtlTemp.isPresent()) {
				GoodsReceiptDtlTemp.get().setMapn(GoodsReceiptDtl.getMapn());
				GoodsReceiptDtlTemp.get().setMathuoc(GoodsReceiptDtl.getMathuoc());
				GoodsReceiptDtlTemp.get().setSoluong(GoodsReceiptDtl.getSoluong());
				GoodsReceiptDtlTemp.get().setDongianhap(GoodsReceiptDtl.getDongianhap());
				return repository.save(GoodsReceiptDtlTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteGoodsReceiptDtl(String id) {
		Optional<GoodsReceiptDtl> GoodsReceiptDtl = repository.findById(id);
		if(GoodsReceiptDtl.isPresent()) {
			repository.delete(GoodsReceiptDtl.get());
			return true;
		}
		return false;
	}
	
}
