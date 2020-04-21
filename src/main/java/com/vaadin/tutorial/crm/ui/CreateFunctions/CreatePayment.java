package com.vaadin.tutorial.crm.ui.CreateFunctions;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.payment.NewPayment;
import com.vaadin.tutorial.crm.service.PaymentService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="CreatePayment", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CreatePayment extends FormLayout {

    private PaymentService paymentService;

   private TextField account;
   private NumberField amount;
   private TextField currency;
   private Button button;

   @Autowired
   public CreatePayment(PaymentService paymentService){
       this.paymentService=paymentService;
       account = new TextField("Account");
       amount = new NumberField("Amount");
       currency = new TextField("Currency");
       button = new Button("Sent");
       button.addClickListener(clickEvent->addPayment());

       add(account);
       add(amount);
       add(currency);
       add(button);

   }

    private void addPayment() {
        NewPayment payment=new NewPayment();
        payment.setAccount(account.getValue());
        payment.setAmount(amount.getValue());
        payment.setCurrency(currency.getValue());
        paymentService.createdNewPayment(payment);
    }


}
