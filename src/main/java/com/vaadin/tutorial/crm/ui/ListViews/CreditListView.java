package com.vaadin.tutorial.crm.ui.ListViews;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.credit.Credits;
import com.vaadin.tutorial.crm.service.CreditService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Route(value="Credits", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CreditListView extends VerticalLayout {

    private Grid<Credits> grid = new Grid<>(Credits.class);

    private CreditService creditService;


    public CreditListView(CreditService creditService) {
        this.creditService=creditService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        updateList();

        add(grid);
    }
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id", "creditName", "creditType", "amount","status");

    }
    //TODO do wywalenia
    @EventListener(ApplicationReadyEvent.class)
    private void updateList() {
        grid.setItems(creditService.fetchCredits());

    }
}
