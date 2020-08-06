package com.amit.ms.limitsservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@ConfigurationProperties("limits-service")
public class Configuration {
    private int minimum;
    private int maximum;
}
