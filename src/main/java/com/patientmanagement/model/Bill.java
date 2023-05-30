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
@Table(name="bienlai")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {
	
	@Id
	private String mabienlai;
	private String manv;
	private String mabn;
	private Date ngaythanhtoan;
	private long giamgia;
	private String hinhthuctt;
	private boolean tinhtrang;
}
