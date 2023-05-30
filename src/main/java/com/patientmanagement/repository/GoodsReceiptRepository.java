package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.GoodsReceipt;
@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt, String>{

}
