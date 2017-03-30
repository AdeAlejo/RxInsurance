package com.canguroSeguro.insurance.app;

import com.netflix.governator.guice.BootstrapModule;
import netflix.karyon.Karyon;
import com.canguroSeguro.insurance.governator.SamplePongAppGovernator;

public class SamplePongGovernatorAppRunner {

    public static void main(String[] args) {
        Karyon.forApplication(SamplePongAppGovernator.class, (BootstrapModule[]) null)
                .startAndWaitTillShutdown();
    }
}
