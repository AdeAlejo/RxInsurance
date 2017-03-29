package com.seguroCanguro.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguroCanguro.consumer.domain.Insurance;
import com.seguroCanguro.consumer.domain.Message;
import com.seguroCanguro.consumer.feign.BackendClient;

@RestController
public class InsuranceController {

    @Autowired
    @Qualifier("hystrixInsuranceClient")	
	private BackendClient client;
    
    @RequestMapping("/insurance")
    public Insurance sendMessage(@RequestBody Message message) {
    	return this.client.sendMessage(message);
    }
	
}
