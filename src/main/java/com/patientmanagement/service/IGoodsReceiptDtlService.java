package com.patientmanagement.service;

import java.util.List;

import com.patientmanagement.model.GoodsReceiptDtl;

public interface IGoodsReceiptDtlService {
	//get all
	public List<GoodsReceiptDtl> getAllGoodsReceiptDtl();

	//get by id
	public GoodsReceiptDtl getById(String id);

	//add
	public GoodsReceiptDtl save(GoodsReceiptDtl GoodsReceiptDtl);

	//update
	public GoodsReceiptDtl updateGoodsReceiptDtl(String id, GoodsReceiptDtl GoodsReceiptDtl);

	//delete
	public boolean deleteGoodsReceiptDtl(String id);
}
