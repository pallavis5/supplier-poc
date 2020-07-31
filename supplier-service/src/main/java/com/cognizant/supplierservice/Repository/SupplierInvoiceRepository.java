package com.cognizant.supplierservice.Repository;

import com.cognizant.supplierservice.Model.SupplierInvoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierInvoiceRepository extends JpaRepository<SupplierInvoice, String>{
    
}