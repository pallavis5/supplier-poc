package com.cognizant.supplierservice.Repository;

import com.cognizant.supplierservice.Model.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
    
}