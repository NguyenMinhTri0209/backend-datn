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
@Table(name="loaidichvu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TofService {
	
	@Id
	private String madv;
	private String tendv;
	private boolean apdungmh;
	private long dongia;
	
}
