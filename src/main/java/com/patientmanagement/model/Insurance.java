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
@Table(name="baohiem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Insurance {

	@Id
	private String mabh;
	private String maloaibh;
	private Date ngaybatdaubh;
	private Date ngaydongbh;
	private Date ngayhethanbh;
	private String diadiemdk;
	
}
