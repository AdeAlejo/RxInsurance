package com.seguroCanguro.consumer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import com.seguroCanguro.noscan.consumer.ribbon.BackendDirectCallRibbonConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@RibbonClients({
    @RibbonClient(name = "insurancedirect", configuration = BackendDirectCallRibbonConfiguration.class),
})
public class InsuranceWebApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(InsuranceWebApplication.class, args);
    }
}
