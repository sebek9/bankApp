package com.vaadin.tutorial.crm.ui.ListViews;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.bond.Bonds;
import com.vaadin.tutorial.crm.service.BondService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Route(value="Bonds", layout = MainLayout.class)
@PageTitle("Bank Application")
public class BondListView extends VerticalLayout {

    private Grid<Bonds> grid = new Grid<>(Bonds.class);

    private BondService bondService;


    public BondListView(BondService bondService) {
        this.bondService=bondService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        updateList();

        add(grid);
    }
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id", "issuer", "units", "unitValue");

    }
    //TODO do wywalenia
    @EventListener(ApplicationReadyEvent.class)
    private void updateList() {
        grid.setItems(bondService.fetchBonds());

    }
}
