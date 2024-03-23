package com.jerri.din.currencyexchangeservice.controllers;

import com.jerri.din.currencyexchangeservice.entities.CurrencyExchange;
import com.jerri.din.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {
        String port = environment.getProperty("local.server.port");
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(from, to);
        if(Objects.isNull(currencyExchange))
            throw  new RuntimeException("Unable to find data for " + from + " to " + to);
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
