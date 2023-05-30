package com.patientmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="loaibaohiem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TofInsurance {
	
	@Id
	private String maloaibh;
	private String tenloaibh;
	private float muchuong;
	
}
