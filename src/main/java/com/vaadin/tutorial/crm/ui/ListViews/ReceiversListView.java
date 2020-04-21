package com.vaadin.tutorial.crm.ui.ListViews;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.receiver.Receivers;
import com.vaadin.tutorial.crm.service.ReceiverService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Route(value="CustomerInfo", layout = MainLayout.class)
@PageTitle("Bank Application")
public class ReceiversListView extends VerticalLayout {

    private Grid<Receivers> grid = new Grid<>(Receivers.class);

    private ReceiverService receiverService;


    public ReceiversListView(ReceiverService receiverService) {
        this.receiverService=receiverService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        updateList();

        add(grid);
    }
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id", "name", "surname", "address");

    }
    //TODO do wywalenia
    @EventListener(ApplicationReadyEvent.class)
    private void updateList() {
        grid.setItems(receiverService.fetchReceivers());

    }
}
