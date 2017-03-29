package com.canguroSeguro.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.canguroSeguro.producer.domain.Insurance;
import com.canguroSeguro.producer.domain.InsuranceCategory;
import com.canguroSeguro.producer.domain.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageHandlerServiceImpl implements MessageHandlerService {
	

    private final String replyMessage;

    @Autowired
    public MessageHandlerServiceImpl(@Value("${reply.message}") String replyMessage) {
        this.replyMessage = replyMessage;
    } 
    
    @Override
    public Insurance handleMessage(Message message) {
        Insurance insurance = new Insurance("10", "SOAT", 100D, "Seguro Obligatorio");
        
        InsuranceCategory insCateOne = new InsuranceCategory();
        insCateOne.setCode("M1");
        insCateOne.setCarType("Vehicle");
        insCateOne.setPriceModifier(1.0D);
        
        InsuranceCategory insCateTwo = new InsuranceCategory();
        insCateTwo.setCode("M2");
        insCateTwo.setCarType("Motorcycle");
        insCateTwo.setPriceModifier(1.5D);
        
        InsuranceCategory insCateThree = new InsuranceCategory();
        insCateThree.setCode("M3");
        insCateThree.setCarType("Truck");
        insCateThree.setPriceModifier(2.0D);      
        
        insurance.getCategories().add(insCateOne);
        insurance.getCategories().add(insCateTwo);
        insurance.getCategories().add(insCateThree);
        
        return insurance;
    }

}
