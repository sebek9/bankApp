package com.vaadin.tutorial.crm.client;

import com.vaadin.tutorial.crm.model.receiver.CreatedNewReceiver;
import com.vaadin.tutorial.crm.model.receiver.NewReceiver;
import com.vaadin.tutorial.crm.model.receiver.Receivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ReceiverClient {

    @Autowired
    private RestTemplate restTemplate;

    //TODO skrocic link
    public List<Receivers> getReceiversList() {
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/receiver/getReceivers")
                .queryParam("fields", "id").build().encode().toUri();

        Receivers[] boardsResponse = restTemplate.getForObject(url, Receivers[].class);
        if (boardsResponse != null) {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }

    public CreatedNewReceiver createdNewReceiver(NewReceiver newReceiver){
        //TODO skrocic link
        URI url = UriComponentsBuilder.fromHttpUrl("https://thawing-cliffs-43759.herokuapp.com/v1/receiver/createReceiver")
                .queryParam("name",newReceiver.getName())
                .queryParam("surname",newReceiver.getSurname())
                .queryParam("address",newReceiver.getAddress()).build().encode().toUri();

        return restTemplate.postForObject(url,newReceiver, CreatedNewReceiver.class);

    }


}
