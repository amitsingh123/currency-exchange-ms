package com.amit.ms.currencyexchangeservice.resource;

import com.amit.ms.currencyexchangeservice.model.CurrencyExchange;
import com.amit.ms.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeResource {
    @Autowired
    Environment environment;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping(path="currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        int port = Integer.valueOf(environment.getProperty("local.server.port"));
        CurrencyExchange currencyExchange =  currencyExchangeRepository.findByFromAndTo(from,to);
        currencyExchange.setPort(port);
        return currencyExchange;
    }
}
