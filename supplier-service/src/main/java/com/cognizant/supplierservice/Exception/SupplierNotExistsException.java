package com.cognizant.supplierservice.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Supplier Not Exist")
public class SupplierNotExistsException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SupplierNotExistsException() {
        
    }
    
}