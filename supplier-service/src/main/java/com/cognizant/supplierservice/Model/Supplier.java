package com.cognizant.supplierservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Supplier")
public class Supplier {
    
	@Id
	@Column(name = "SupplierId")
    private String supplierId;

	@Column(name = "SupplierName")
	private String supplierName;

	@Column(name = "Location")
	private String location;
    
}