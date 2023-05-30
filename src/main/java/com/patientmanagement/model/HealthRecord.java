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
@Table(name="hosobenhan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthRecord {

	@Id
	private String mahsba;
	private String mabn;
	private String mabs;
	private Date ngaybd;
	private Date ngaykt;
	private String cdvaovien;
	private String cdravien;
	private String tomtatba;
	private String ghichu;
	
}
