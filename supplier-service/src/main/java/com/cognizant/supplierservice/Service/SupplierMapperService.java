package com.cognizant.supplierservice.Service;

import java.util.concurrent.Future;

import com.cognizant.supplierservice.Model.Supplier;
import com.cognizant.supplierservice.Model.SupplierInvoice;
import com.cognizant.supplierservice.Repository.SupplierInvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapperService {

    @Autowired
    SupplierInvoiceRepository supplierInvoiceRepository;

    @Async
    public Future<String> SupplierMapperInvoice(Supplier supplier, String supplierId) { // method to resemble invoice
                                                                                        // and async method

        SupplierInvoice supplierInvoice = new SupplierInvoice();
        supplierInvoice.setSupplierId(supplierId);
        supplierInvoice.setSupplierName(supplier.getSupplierName());
        supplierInvoice.setLocation(supplier.getLocation());
        supplierInvoiceRepository.save(supplierInvoice);
        return new AsyncResult<String>("Invoice Success");

    }

}