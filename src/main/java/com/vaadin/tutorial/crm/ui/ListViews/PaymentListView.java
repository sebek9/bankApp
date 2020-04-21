package com.vaadin.tutorial.crm.ui.ListViews;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.payment.Payments;
import com.vaadin.tutorial.crm.service.PaymentService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Route(value="Payments", layout = MainLayout.class)
@PageTitle("Bank Application")
public class PaymentListView extends VerticalLayout{

    private Grid<Payments> grid = new Grid<>(Payments.class);

    private PaymentService paymentService;

    public PaymentListView(PaymentService paymentService) {
        this.paymentService=paymentService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        updateList();

        add(grid);
    }
    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("id", "account", "amount", "currency");

    }
    //TODO do wywalenia
    @EventListener(ApplicationReadyEvent.class)
    private void updateList() {
       grid.setItems(paymentService.fetchPayments());

    }
}
