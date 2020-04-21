package com.vaadin.tutorial.crm.model.bond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedNewBond {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("units")
    private Integer units;
    @JsonProperty("unitValue")
    private String unitValue;


}
