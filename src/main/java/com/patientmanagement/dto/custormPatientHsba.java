package com.patientmanagement.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class custormPatientHsba {
	private String mahsba;
	private String mabn;
	private String ten;
	private String mabs;
	private boolean gioitinh;
	private Date ngaysinh;
	private Date ngaybd;
	private Date ngaykt;
	private String mabhyt;
	private String cdvaovien;
	private String cdravien;
	private String tomtatba;
	private String ghichu;
}
