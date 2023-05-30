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
@Table(name="thuoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medicine {
	
	@Id
	private String mathuoc;
	private String tenthuoc;
	private long dongia;
	private String donvitinh;
	private String cachdung;
	private String thanhphan;
	private String hansd;
	private String hangsx;
	private Date ngaysx;
}
