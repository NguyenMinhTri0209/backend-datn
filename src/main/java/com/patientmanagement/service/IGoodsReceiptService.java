package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.GoodsReceipt;

public interface IGoodsReceiptService {
	//get all
	public List<GoodsReceipt> getAllGoodsReceipt();

	//get by id
	public GoodsReceipt getById(String id);

	//add
	public GoodsReceipt save(GoodsReceipt GoodsReceipt);

	//update
	public GoodsReceipt updateGoodsReceipt(String id, GoodsReceipt GoodsReceipt);

	//delete
	public boolean deleteGoodsReceipt(String id);
}
