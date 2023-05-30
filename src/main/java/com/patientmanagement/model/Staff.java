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
@Table(name="nhanvien")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {

	@Id
	private String manv;
	private String ten;
	private Date ngaysinh;
	private String diachi;
	private boolean gioitinh;
	private String chucvu;
	private String sodienthoai;
	private String tentk;
	private String matkhau;
	private String quyen;
}
