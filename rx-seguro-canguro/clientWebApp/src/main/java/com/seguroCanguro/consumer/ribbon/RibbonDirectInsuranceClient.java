package com.seguroCanguro.consumer.ribbon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;
import com.seguroCanguro.consumer.domain.Insurance;
import com.seguroCanguro.consumer.domain.Message;
import com.seguroCanguro.consumer.feign.BackendClient;

@Service("ribbonDirectInsuranceClient")
public class RibbonDirectInsuranceClient implements BackendClient {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;	
	
	@Override
	public Insurance sendMessage(Message message) {
        String pongServiceUrl = "http://insurancedirect/message";
        HttpEntity<Message> requestEntity = new HttpEntity<>(message);
        ResponseEntity<Insurance> response = this.restTemplate.exchange(pongServiceUrl, HttpMethod.POST, requestEntity, Insurance.class, Maps.newHashMap());
		return response.getBody();
	}

}
