package com.amit.ms.currencyexchangeservice.repository;

import com.amit.ms.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

    public CurrencyExchange findByFromAndTo(String from,String to);
}
