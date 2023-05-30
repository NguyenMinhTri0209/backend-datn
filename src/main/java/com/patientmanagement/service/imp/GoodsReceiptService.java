package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.GoodsReceipt;
import com.patientmanagement.repository.GoodsReceiptRepository;
import com.patientmanagement.service.IGoodsReceiptService;

@Service
public class GoodsReceiptService implements IGoodsReceiptService{

	@Autowired
	private GoodsReceiptRepository goodsReceiptRepository;
	
	@Override
	public List<GoodsReceipt> getAllGoodsReceipt() {
		List<GoodsReceipt> GoodsReceipt = goodsReceiptRepository.findAll();
		if(GoodsReceipt.size() == 0)
			return null;
		else
			return GoodsReceipt;
	}

	@Override
	public GoodsReceipt getById(String id) {
		Optional<GoodsReceipt> GoodsReceipt = goodsReceiptRepository.findById(id);
		if(GoodsReceipt.isPresent())
			return GoodsReceipt.get();
		else
			return null;
	}

	@Override
	public GoodsReceipt save(GoodsReceipt GoodsReceipt) {
		if(GoodsReceipt != null) {
			return goodsReceiptRepository.save(GoodsReceipt);
		}
		return null;
	}

	@Override
	public GoodsReceipt updateGoodsReceipt(String id, GoodsReceipt GoodsReceipt) {
		if(GoodsReceipt != null) {
			Optional<GoodsReceipt> GoodReceiptTemp = goodsReceiptRepository.findById(id);
			if(GoodReceiptTemp.isPresent()) {
				GoodReceiptTemp.get().setManv(GoodsReceipt.getManv());
				GoodReceiptTemp.get().setNgaynhap(GoodsReceipt.getNgaynhap());
				GoodReceiptTemp.get().setTinhtrangtt(GoodsReceipt.isTinhtrangtt());
				GoodReceiptTemp.get().setMancc(GoodsReceipt.getMancc());
				return goodsReceiptRepository.save(GoodReceiptTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteGoodsReceipt(String id) {
		Optional<GoodsReceipt> GoodsReceipt = goodsReceiptRepository.findById(id);
		if(GoodsReceipt.isPresent()) {
			goodsReceiptRepository.delete(GoodsReceipt.get());
			return true;
		}
		return false;
	}

	
	
}
