package com.vaadin.tutorial.crm.ui.ListViews;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.card.Cards;
import com.vaadin.tutorial.crm.service.CardService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Route(value="Cards", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CardListView extends VerticalLayout {

    private Grid<Cards> grid = new Grid<>(Cards.class);

    private CardService cardService;


    public CardListView(CardService cardService) {
        this.cardService=cardService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        updateList();

        add(grid);
    }
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id", "cardNumber", "cardType", "cardHolder","status");

    }
    //TODO do wywalenia
    @EventListener(ApplicationReadyEvent.class)
    private void updateList() {
        grid.setItems(cardService.fetchCards());

    }
}
