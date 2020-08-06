package com.amit.ms.limitsservice.config;

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
}
