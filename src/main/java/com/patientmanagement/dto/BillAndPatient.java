package com.patientmanagement.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillAndPatient {
	private String mabienlai;
	private String manv;
	private String tennv;
	private String mabn;
	private String tenbn;
	private String mabh;
	private Date ngaythanhtoan;
	private long giamgia;
	private String hinhthuctt;
	private boolean tinhtrang;
}
