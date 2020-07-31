package com.cognizant.supplierservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SupplierInvoice")
public class SupplierInvoice {

    @Id
	@Column(name = "SupplierId")
    private String supplierId;

	@Column(name = "SupplierName")
	private String supplierName;

	@Column(name = "Location")
	private String location;
    
}