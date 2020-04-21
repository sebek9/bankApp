package com.vaadin.tutorial.crm.service;

import com.vaadin.tutorial.crm.client.CurrencyClient;
import com.vaadin.tutorial.crm.model.exchange.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyClient currencyClient;

    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    public List<Currencies> fetchCurrencies() {
        return currencyClient.getCurrencyList();
    }
}
