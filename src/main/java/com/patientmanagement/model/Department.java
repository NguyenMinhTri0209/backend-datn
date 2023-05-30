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
@Table(name="khoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {

	@Id
	private String makhoa;
	private String tenkhoa;
	private String chuyenmon;
	
}
