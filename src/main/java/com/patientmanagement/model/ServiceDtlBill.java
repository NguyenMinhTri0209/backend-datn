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
@Table(name="chitietdichvukham")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceDtlBill {
	
	@Id
	private String madvctkham;
	private String madvkham;
	private String madv;
	private Long soluong;
	
}
