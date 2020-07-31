package com.cognizant.supplierservice.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import com.cognizant.supplierservice.Exception.SupplierNotExistsException;
import com.cognizant.supplierservice.Model.Supplier;
import com.cognizant.supplierservice.Repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SupplierManagementService {

  @Autowired
  SupplierRepository supplierRepository;

  @Autowired
  SupplierMapperService supplierMapperService;

  public String addSupplier(String supplierId) { //to create a new supplier when he signs in

    Supplier supplierData = new Supplier();
    supplierData.setSupplierId(supplierId);
    supplierRepository.save(supplierData);
    return ("Added Sucessfully");
  }

  public String addSupplierDetails(String supplierId, Supplier postSupplier)
      throws SupplierNotExistsException, InterruptedException, ExecutionException { //to add supplier details

    Optional<Supplier> supplier = supplierRepository.findById(supplierId);
    if (supplier.isPresent()) {
      Supplier obtSupplier = supplier.get();
      obtSupplier.setSupplierName(postSupplier.getSupplierName());
      obtSupplier.setLocation(postSupplier.getLocation());
      supplierRepository.save(obtSupplier);
      String asyncResult = supplierMapperService.SupplierMapperInvoice(postSupplier, supplierId).get();
      return ("Post Success " + asyncResult);

    } else {
      throw new SupplierNotExistsException();
    }
  }

  public Supplier getSupplier(String supplierId) throws SupplierNotExistsException {

    Optional<Supplier> supplier = supplierRepository.findById(supplierId);
    if (supplier.isPresent()) {
      Supplier obtSupplier = supplier.get();
      log.info("supplier.." + obtSupplier);
      return obtSupplier;
    } else {
      throw new SupplierNotExistsException();
    }
  }

}
