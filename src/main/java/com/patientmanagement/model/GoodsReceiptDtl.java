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
@Table(name="chitietphieunhap")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoodsReceiptDtl {
	
	@Id
	private String mactpn;
	private String mapn;
	private String mathuoc;
	private long soluong;
	private long dongianhap;
	
}
