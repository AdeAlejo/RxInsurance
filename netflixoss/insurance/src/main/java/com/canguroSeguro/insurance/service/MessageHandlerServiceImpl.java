package com.canguroSeguro.insurance.service;

import com.canguroSeguro.insurance.domain.Message;
import com.canguroSeguro.insurance.domain.Insurance;
import com.canguroSeguro.insurance.domain.InsuranceCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

public class MessageHandlerServiceImpl implements MessageHandlerService {
    private static final Logger logger = LoggerFactory.getLogger(MessageHandlerServiceImpl.class);

    public Observable<Insurance> handleMessage(Message message) {
        return Observable.<Insurance>create(s -> {
            
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

            s.onNext(insurance);
            s.onCompleted();
        });
    }


}
