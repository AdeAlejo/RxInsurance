package com.seguroCanguro.consumer.ribbon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.google.common.collect.Maps;
import com.seguroCanguro.consumer.domain.Insurance;
import com.seguroCanguro.consumer.domain.Message;
import com.seguroCanguro.consumer.feign.BackendClient;


@Service("restTemplateDirectInsuranceClient")
public class RestTemplateDirectInsuranceClient implements BackendClient {

	private final RestOperations restTemplate;
	
    @Autowired
    public RestTemplateDirectInsuranceClient(@Qualifier("nonLoadbalancedRestTemplate") RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }
    
	@Override
	public Insurance sendMessage(Message message) {
        String insuranceServiceUrl = "http://localhost:8082/message";
        HttpEntity<Message> requestEntity = new HttpEntity<>(message);
        
        ResponseEntity<Insurance> response =  this.restTemplate.exchange(insuranceServiceUrl, HttpMethod.POST, requestEntity, Insurance.class, Maps.newHashMap());
		
        return response.getBody();
	}

}
