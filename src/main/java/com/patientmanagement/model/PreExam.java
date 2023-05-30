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
@Table(name="khamsobo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PreExam {
	
	@Id
	private String makham;
	private Date ngaykham;
	private String mabs;
	private String mabn;
	private String mabenh;
	private long cpkham;
}
