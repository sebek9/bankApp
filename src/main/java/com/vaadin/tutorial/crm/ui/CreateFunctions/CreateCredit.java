package com.vaadin.tutorial.crm.ui.CreateFunctions;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.credit.NewCredit;
import com.vaadin.tutorial.crm.service.CreditService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="CreateCredit", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CreateCredit extends FormLayout {

    private CreditService creditService;



    private TextField creditName;
    private TextField creditType;
    private IntegerField amount;
    private TextField status;
    private Button button;

    @Autowired
    public CreateCredit(CreditService creditService){
        this.creditService=creditService;
        creditName = new TextField("Credit name");
        creditType = new TextField("Credit type");
        amount = new IntegerField("Amount");
        status = new TextField("Status");
        button = new Button("Sent");
        button.addClickListener(clickEvent->addCard());

        add(creditName);
        add(creditType);
        add(amount);
        add(status);
        add(button);

    }

    private void addCard() {
        NewCredit credit=new NewCredit();
        credit.setCreditName(creditName.getValue());
        credit.setCreditType(creditType.getValue());
        credit.setAmount(amount.getValue());
        credit.setStatus(status.getValue());
        creditService.createdNewCredit(credit);
    }


}
