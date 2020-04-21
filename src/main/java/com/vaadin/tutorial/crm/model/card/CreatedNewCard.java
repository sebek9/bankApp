package com.vaadin.tutorial.crm.model.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedNewCard {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("cardHolder")
    private String cardHolder;
    @JsonProperty("status")
    private String status;


}
