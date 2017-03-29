package com.seguroCanguro.consumer.feign;

import com.seguroCanguro.consumer.domain.Insurance;
import com.seguroCanguro.consumer.domain.Message;

public interface BackendClient {
	
	Insurance sendMessage(Message message);

}
