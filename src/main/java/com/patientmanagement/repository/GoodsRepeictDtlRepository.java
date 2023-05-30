package com.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.model.GoodsReceiptDtl;
@Repository
public interface GoodsRepeictDtlRepository extends JpaRepository<GoodsReceiptDtl, String>{

}
