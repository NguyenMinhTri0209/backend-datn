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
@Table(name="loaixetnghiem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestDtl {
	
	@Id
	private String maloaixn;
	private String tenxn;
	private long dongia;
	
}
