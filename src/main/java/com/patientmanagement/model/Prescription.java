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
@Table(name="phieuthuoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prescription {
	
	@Id
	private String maphieuthuoc;
	private String mabn;
	private String mabs;
	private Date ngayxuatthuoc;
	
}
