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
@Table(name="quantrivien")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminPage {
	
	@Id
	private String tentk;
	private String ten;
	private	String matkhau;
	private String quyen;
	
}
