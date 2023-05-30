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
@Table(name="phieunhap")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoodsReceipt {
	
	@Id
	private String mapn;
	private String manv;
	private Date ngaynhap;
	private boolean tinhtrangtt;
	private String mancc;
	
}
