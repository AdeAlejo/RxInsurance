package com.canguroSeguro.insurance.config;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.canguroSeguro.insurance.service.MessageHandlerService;
import com.canguroSeguro.insurance.service.MessageHandlerServiceImpl;

public class AppModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(MessageHandlerService.class).to(MessageHandlerServiceImpl.class).in(Scopes.SINGLETON);
    }
}
