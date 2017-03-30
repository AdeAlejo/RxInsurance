package com.canguroSeguro.insurance.config;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.netty.buffer.ByteBuf;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.transport.http.SimpleUriRouter;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import com.canguroSeguro.insurance.app.ApplicationMessageHandler;
import com.canguroSeguro.insurance.common.health.HealthCheck;

public class AppRouteProvider implements Provider<SimpleUriRouter<ByteBuf, ByteBuf>> {

    @Inject
    private HealthCheck healthCheck;

    @Inject
    private ApplicationMessageHandler applicationMessageHandler;

    @Override
    public SimpleUriRouter get() {
        SimpleUriRouter simpleUriRouter = new SimpleUriRouter();
        simpleUriRouter.addUri("/healthcheck", new HealthCheckEndpoint(healthCheck));
        simpleUriRouter.addUri("/message", applicationMessageHandler);
        return simpleUriRouter;
    }
}