package com.vaadin.tutorial.crm.service;

import com.vaadin.tutorial.crm.client.CardClient;
import com.vaadin.tutorial.crm.model.card.Cards;
import com.vaadin.tutorial.crm.model.card.CreatedNewCard;
import com.vaadin.tutorial.crm.model.card.NewCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardClient cardClient;

    public CardService(CardClient cardClient) {
        this.cardClient = cardClient;
    }

    public List<Cards> fetchCards(){
        return cardClient.getCardsList();
    }

    public CreatedNewCard createdNewCard(final NewCard newCard){
        CreatedNewCard addCard =cardClient.createNewCard(newCard);
        return addCard;
    }

}
