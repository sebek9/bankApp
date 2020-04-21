package com.vaadin.tutorial.crm.service;

import com.vaadin.tutorial.crm.client.BondClient;
import com.vaadin.tutorial.crm.model.bond.Bonds;
import com.vaadin.tutorial.crm.model.bond.CreatedNewBond;
import com.vaadin.tutorial.crm.model.bond.NewBond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondService {
    @Autowired
    private BondClient bondClient;

    public BondService(BondClient bondClient) {
        this.bondClient = bondClient;
    }

    public List<Bonds> fetchBonds(){
        return bondClient.getBondsList();
    }

    public CreatedNewBond createdNewBond(final NewBond newBond){
        CreatedNewBond addBond =bondClient.createdNewBond(newBond);
        return addBond;
    }

}
