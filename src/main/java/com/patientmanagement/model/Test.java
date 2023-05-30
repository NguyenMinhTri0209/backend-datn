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
@Table(name="phieuxetnghiem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Test {

	@Id
	private String maxn;
	private String maloaixn;
	private String mabn;
	private Date ngayxn;
	private String kquaxn;
	private String lydoxn;
}
