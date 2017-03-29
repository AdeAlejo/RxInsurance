package com.seguroCanguro.consumer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seguroCanguro.consumer.domain.Insurance;
import com.seguroCanguro.consumer.domain.Message;
import com.seguroCanguro.consumer.feign.BackendClient;

@Service("hystrixInsuranceClient")
public class HystrixWrappedInsuranceClient implements BackendClient {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(HystrixWrappedInsuranceClient.class);
	
    @Autowired
    @Qualifier("ribbonInsuranceClient")
	private BackendClient client;
	
    @Override
    @HystrixCommand(commandKey = "insuranceCommand", groupKey = "insuranceGroup", fallbackMethod = "fallBackCall")
	public Insurance sendMessage(Message message) {
    	return this.client.sendMessage(message);
	}
    
    public Insurance fallBackCall(Message message, Throwable e) {
    	LOGGER.error("In fallback: ", e);
    	return new Insurance();
    }

}
