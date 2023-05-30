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
@Table(name="chitietphieuthuoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prescriptiondtl {
	
	@Id
	private String mactpn;
	private String maphieuthuoc;
	private String mathuoc;
	private byte soluong;
	
}


