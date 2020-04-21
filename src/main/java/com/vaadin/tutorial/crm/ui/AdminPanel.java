package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.payment.Payments;
import com.vaadin.tutorial.crm.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="AdminPanel", layout = MainLayout.class)
@PageTitle("Bank Application")
public class AdminPanel extends FormLayout {

    private PaymentService paymentService;

    private TextField paymentId;
    private NumberField receiverId;
    private Button button;
    private Button button1;

    @Autowired
    public AdminPanel(){
        paymentId = new TextField("Payment id");
        receiverId = new NumberField("Receiver id");
        button = new Button("Delete");
        button1 = new Button("Delete");
        button.addClickListener(clickEvent->deletePayment());

        add(paymentId);
        add(button);
        add(receiverId);
        add(button1);


    }
//TODO error
    private void deletePayment() {
        Payments payment=new Payments();
        payment.setId(Long.parseLong(paymentId.getValue()));
       // payment.setAccount(payment.getAccount());
        payment.setAccount("23");
        payment.setAmount(12.0);
        payment.setCurrency("czy to prawda");

        paymentService.deletePayment(payment);
    }
    }

