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
@Table(name="dichvukham")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Service {
	
	@Id
	private String madvkham;
	private String mabn;
	private Date ngaysd;
	
}
