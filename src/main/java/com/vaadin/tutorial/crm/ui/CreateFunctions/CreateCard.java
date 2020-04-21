package com.vaadin.tutorial.crm.ui.CreateFunctions;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.card.NewCard;
import com.vaadin.tutorial.crm.service.CardService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="CreateCard", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CreateCard extends FormLayout {

    private CardService cardService;

    // grid.setColumns("id", "cardNumber", "cardType", "cardHolder","status");

    private TextField cardNumber;
    private TextField cardType;
    private TextField cardHolder;
    private TextField status;
    private Button button;

    @Autowired
    public CreateCard(CardService cardService){
        this.cardService=cardService;
        cardNumber = new TextField("Card number");
        cardType = new TextField("Card type");
        cardHolder = new TextField("Cardholder");
        status = new TextField("Status");
        button = new Button("Sent");
        button.addClickListener(clickEvent->addCard());

        add(cardNumber);
        add(cardType);
        add(cardHolder);
        add(status);
        add(button);

    }

    private void addCard() {
        NewCard card=new NewCard();
        card.setCardNumber(cardNumber.getValue());
        card.setCardType(cardType.getValue());
        card.setCardHolder(cardHolder.getValue());
        card.setStatus(status.getValue());
        cardService.createdNewCard(card);
    }


}
