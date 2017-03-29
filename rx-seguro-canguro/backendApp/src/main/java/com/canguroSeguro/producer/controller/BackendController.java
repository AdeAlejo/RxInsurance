package com.canguroSeguro.producer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.canguroSeguro.producer.domain.Insurance;
import com.canguroSeguro.producer.domain.Message;
import com.canguroSeguro.producer.service.MessageHandlerService;

@RestController
public class BackendController {
	
	private final MessageHandlerService messageHandlerService;
	
	@Autowired
	public BackendController(MessageHandlerService messageHandlerService){
		this.messageHandlerService = messageHandlerService;
	}
	
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Resource<Insurance> pongMessage(@RequestBody Message input) {
        return new Resource<>(this.messageHandlerService.handleMessage(input));
    }


}
