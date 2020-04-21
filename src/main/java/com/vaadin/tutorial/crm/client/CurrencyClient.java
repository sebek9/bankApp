package com.vaadin.tutorial.crm.client;

import com.vaadin.tutorial.crm.model.exchange.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CurrencyClient {

    @Autowired
    private RestTemplate restTemplate;

    //TODO skrocic link
    public List<Currencies> getCurrencyList() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://api.exchangeratesapi.io/latest?base=PLN")
                .queryParam("base", "PLN").build().encode().toUri();

        Currencies[] boardsResponse = restTemplate.getForObject(url, Currencies[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }
}
