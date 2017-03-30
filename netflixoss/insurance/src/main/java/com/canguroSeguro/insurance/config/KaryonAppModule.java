package com.canguroSeguro.insurance.config;

import io.netty.buffer.ByteBuf;
import netflix.karyon.transport.http.KaryonHttpModule;
import com.canguroSeguro.insurance.common.LoggingInterceptor;


public class KaryonAppModule extends KaryonHttpModule<ByteBuf, ByteBuf> {

    public KaryonAppModule() {
        super("routerModule", ByteBuf.class, ByteBuf.class);
    }

    @Override
    protected void configureServer() {
        bindRouter().toProvider(new AppRouteProvider());

        interceptorSupport().forUri("/*").intercept(LoggingInterceptor.class);

        server().port(8888);
    }
}