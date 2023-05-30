package com.patientmanagement.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicineDto {
	private String maphieuthuoc;
	private String mabn;
	private String mabs;
//	private String mathuoc;
	private String tenbn;
	private String tenbs;
//	private String mactpt;
//	private String tenthuoc;
//	private String soluong;
	private Date ngayxuatthuoc;
}
