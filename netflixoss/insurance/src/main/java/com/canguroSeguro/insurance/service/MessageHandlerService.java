package com.canguroSeguro.insurance.service;

import com.canguroSeguro.insurance.domain.Message;
import com.canguroSeguro.insurance.domain.Insurance;
import rx.Observable;

public interface MessageHandlerService {
    Observable<Insurance> handleMessage(Message message);
}
