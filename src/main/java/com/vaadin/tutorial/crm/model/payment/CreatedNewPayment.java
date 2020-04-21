package com.vaadin.tutorial.crm.model.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedNewPayment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("account")
    private String account;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;


}
