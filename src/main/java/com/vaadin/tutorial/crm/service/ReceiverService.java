package com.vaadin.tutorial.crm.service;

import com.vaadin.tutorial.crm.client.ReceiverClient;
import com.vaadin.tutorial.crm.model.receiver.CreatedNewReceiver;
import com.vaadin.tutorial.crm.model.receiver.NewReceiver;
import com.vaadin.tutorial.crm.model.receiver.Receivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReceiverService {
    @Autowired
    private ReceiverClient receiverClient;

    public ReceiverService(ReceiverClient receiverClient) {
        this.receiverClient = receiverClient;
    }

    public List<Receivers> fetchReceivers(){
        return receiverClient.getReceiversList();
    }

    public CreatedNewReceiver createdNewReceiver(final NewReceiver newReceiver){
        CreatedNewReceiver newReceiver1 =receiverClient.createdNewReceiver(newReceiver);
        return newReceiver1;
    }

}