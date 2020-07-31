package com.cognizant.authenticationservice.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SupplierRequestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${com.cognizant.SupplierService.addSupplier}")
    private String addSupplierUri;

    @HystrixCommand(fallbackMethod = "errorMethod")
    public String postSupplier(String supplierId) { //rest template communication and hystrix enabled
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        log.info("entity" + entity);
        restTemplate.exchange(addSupplierUri, HttpMethod.POST, entity, String.class, supplierId).getBody();
        return ("Post Success");
    }

    public String errorMethod(String supplierId) {
        return ("Post Failure-SupplierServiceDown");
    }

}