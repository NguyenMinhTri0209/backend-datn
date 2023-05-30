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
@Table(name="dangkylichkham")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterService {
	
	@Id
	private String malichkham;
	private Date ngaykham;
	private String mabn;
	private String mabs;
	private String madvkham;
	private boolean tinhtrang;
	private String ghichu;
}
