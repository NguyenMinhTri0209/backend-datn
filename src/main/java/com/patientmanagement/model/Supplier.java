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
@Table(name="nhacungcap")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supplier {
	
	@Id
	private String mancc;
	private String tenncc;
	private String diachi;
	private String sodienthoai;
	private String email;
	private String quocgia;
	
}
