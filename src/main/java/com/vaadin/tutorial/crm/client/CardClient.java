package com.vaadin.tutorial.crm.client;


import com.vaadin.tutorial.crm.model.card.Cards;
import com.vaadin.tutorial.crm.model.card.CreatedNewCard;
import com.vaadin.tutorial.crm.model.card.NewCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CardClient {

    @Autowired
    private RestTemplate restTemplate;

    //TODO skrocic link
    public List<Cards> getCardsList() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/card/getCards")
                .queryParam("fields", "id").build().encode().toUri();

        Cards[] boardsResponse = restTemplate.getForObject(url, Cards[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }

    public CreatedNewCard createNewCard(NewCard newCard){
        //TODO skrocic link
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/card/createCard")
                .queryParam("cardNumber",newCard.getCardNumber())
                .queryParam("cardType",newCard.getCardType())
                .queryParam("cardHolder",newCard.getCardHolder())
                .queryParam("currency",newCard.getStatus()).build().encode().toUri();

        return restTemplate.postForObject(url,newCard, CreatedNewCard.class);

    }
}
