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
@Table(name="benhnhan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {
	
	@Id
	private String mabn;
	private String ten;
	private Date ngaysinh;
	private String email;
	private boolean gioitinh;
	private String sodienthoai;
	private String cccd;
	private String mabh;
	private String nghenghiep;
	
}
