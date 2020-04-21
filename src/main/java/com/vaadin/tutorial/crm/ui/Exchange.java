package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="Exchange", layout = MainLayout.class)
@PageTitle("Bank Application")
public class Exchange extends FormLayout {

    private CurrencyService currencyService;

    private NumberField valueInPln;
    private NumberField valueInCurrency;
    private Button button;

    @Autowired
    public Exchange(CurrencyService currencyService){
        this.currencyService=currencyService;
        valueInPln = new NumberField("Amount in PLN");
        //TODO to pole nie powinno byc klikalne
        valueInCurrency = new NumberField("Amount in EUR");
        button = new Button("Go");
        button.addClickListener(clickEvent->exchangeCurrency());

        add(valueInPln);
        add(button);
        add(valueInCurrency);
    }

    private void exchangeCurrency() {

    }
}

