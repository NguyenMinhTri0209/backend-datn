package com.patientmanagement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bacsi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {

	@Id
	private String mabs;
	private String makhoa;
	private String ten;
	private String diachi;
	private String sodienthoai;
	private boolean gioitinh;
	private Date ngaysinh;
	private String trinhdo;
	private String chuyenmon;
	private String chucvu;
	private String tentk;
	private String matkhau;
	private String quyen;
	
}
