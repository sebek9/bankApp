package com.vaadin.tutorial.crm.model.credit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedNewCredit {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("creditName")
    private String creditName;
    @JsonProperty("creditType")
    private String creditType;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("status")
    private String status;


}
