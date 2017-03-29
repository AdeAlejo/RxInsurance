package com.canguroSeguro.producer.service;

import com.canguroSeguro.producer.domain.Insurance;
import com.canguroSeguro.producer.domain.Message;



public interface MessageHandlerService {
	
	
	Insurance handleMessage(Message message);

}
