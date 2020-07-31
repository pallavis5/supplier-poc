package com.cognizant.supplierservice.Controller;

import java.util.concurrent.ExecutionException;

import com.cognizant.supplierservice.Exception.SupplierNotExistsException;
import com.cognizant.supplierservice.Model.Supplier;
import com.cognizant.supplierservice.Service.SupplierManagementService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/supplier")
@Slf4j
public class SupplierManagementController {

    @Autowired
    SupplierManagementService supplierManagementService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addSupplier/{supplierId}")
    public String addSupplier(@PathVariable("supplierId") String supplierId) {
        System.out.println("inside controller");
        return supplierManagementService.addSupplier(supplierId);
    }

    @GetMapping("/getProduct/{supplierId}")
    @HystrixCommand(fallbackMethod = "timeout", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
    public Supplier getSupplier(@PathVariable("supplierId") String supplierId) // hystrix enabled
            throws SupplierNotExistsException, InterruptedException {
        // Thread.sleep(2000); //if thread sleeps, hystrix gets enabled
        return supplierManagementService.getSupplier(supplierId);
    }

    public Supplier timeout(String supplierId) { // hystrix fallback method
        log.info("Request Timed-out");
        return null;
    }

    @PostMapping("/addProduct/{supplierId}")
    public String addSupplierDetails(@PathVariable("supplierId") String supplierId, @RequestBody Supplier supplier)
            throws SupplierNotExistsException, InterruptedException, ExecutionException {
        System.out.println("controller inside ");
        return supplierManagementService.addSupplierDetails(supplierId, supplier);
    }

}