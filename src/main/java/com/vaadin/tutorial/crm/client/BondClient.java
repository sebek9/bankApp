package com.vaadin.tutorial.crm.client;

import com.vaadin.tutorial.crm.model.bond.Bonds;
import com.vaadin.tutorial.crm.model.bond.CreatedNewBond;
import com.vaadin.tutorial.crm.model.bond.NewBond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component

public class BondClient {

    @Autowired
    private RestTemplate restTemplate;

    //TODO skrocic link
    public List<Bonds> getBondsList() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/bond/getBonds")
                .queryParam("fields", "id").build().encode().toUri();

        Bonds[] boardsResponse = restTemplate.getForObject(url, Bonds[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }

    public CreatedNewBond createdNewBond(NewBond newBond){
        //TODO skrocic link
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/bond/createBond")
                .queryParam("issuer",newBond.getIssuer())
                .queryParam("units",newBond.getUnits())
                .queryParam("unitValue",newBond.getUnitValue()).build().encode().toUri();

        return restTemplate.postForObject(url,newBond, CreatedNewBond.class);

    }
}
