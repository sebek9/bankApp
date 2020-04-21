package com.vaadin.tutorial.crm.service;

import com.vaadin.tutorial.crm.client.CreditClient;
import com.vaadin.tutorial.crm.model.credit.CreatedNewCredit;
import com.vaadin.tutorial.crm.model.credit.Credits;
import com.vaadin.tutorial.crm.model.credit.NewCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {
    @Autowired
    private CreditClient creditClient;

    public CreditService(CreditClient creditClient) {
        this.creditClient = creditClient;
    }

    public List<Credits> fetchCredits(){
        return creditClient.getCreditList();
    }

    public CreatedNewCredit createdNewCredit(final NewCredit newCredit){
        CreatedNewCredit addCredit =creditClient.createdNewCredit(newCredit);
        return addCredit;
    }

}
