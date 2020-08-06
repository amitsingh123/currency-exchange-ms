package com.amit.ms.currencyconversionservice.resource;

import com.amit.ms.currencyconversionservice.model.CurrencyConversion;
import com.amit.ms.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CurrencyExchangeServiceProxy proxy;

    @GetMapping (path="/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion> conversionResponseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion response = conversionResponseEntity.getBody();
        return new CurrencyConversion
                (response.getId(),from,to, response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }

    @GetMapping (path="/currency-convert-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
        CurrencyConversion response = proxy.getCurrencyExchangeValue(from,to);
        return new CurrencyConversion
                (response.getId(),from,to, response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }
}
