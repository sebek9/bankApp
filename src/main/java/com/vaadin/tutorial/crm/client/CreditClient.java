package com.vaadin.tutorial.crm.client;

import com.vaadin.tutorial.crm.model.credit.CreatedNewCredit;
import com.vaadin.tutorial.crm.model.credit.Credits;
import com.vaadin.tutorial.crm.model.credit.NewCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CreditClient {

    @Autowired
    private RestTemplate restTemplate;

    //TODO skrocic link
    public List<Credits> getCreditList() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/credit/getCredits")
                .queryParam("fields", "id").build().encode().toUri();

        Credits[] boardsResponse = restTemplate.getForObject(url, Credits[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }

    public CreatedNewCredit createdNewCredit(NewCredit newCredit){
        //TODO skrocic link
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/card/createCredit")
                .queryParam("creditName",newCredit.getCreditName())
                .queryParam("creditType",newCredit.getCreditType())
                .queryParam("amount",newCredit.getAmount())
                .queryParam("currency",newCredit.getStatus()).build().encode().toUri();

        return restTemplate.postForObject(url,newCredit, CreatedNewCredit.class);

    }
}
