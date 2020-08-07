package com.amit.ms.limitsservice.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfiguration {

    @Autowired
    private Configuration configuration;

    @GetMapping(path = "/limits")
    public Configuration getConfiguration() {
        return new Configuration(configuration.getMinimum(), configuration.getMaximum());
    }

    //Demo for Hystrix fault tolerant
    @GetMapping(path = "/fault-tolerant-limits")
    @HystrixCommand(fallbackMethod = "fallbackRateLimit")
    public Configuration getConfigurationFaultTolerant() {
        throw new RuntimeException("Not found");
    }

    public Configuration fallbackRateLimit() {
        return new Configuration(configuration.getMinimum(),configuration.getMaximum());
    }
}
