package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.tutorial.crm.ui.CreateFunctions.*;
import com.vaadin.tutorial.crm.ui.ListViews.*;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    private CreatePayment createPaymentForm;

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Bank Application");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

        header.setDefaultVerticalComponentAlignment(
                FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");

        addToNavbar(header);

    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Main view", ListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink2 = new RouterLink("Payments list", PaymentListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink3 = new RouterLink("Receivers list", ReceiversListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink4 = new RouterLink("Create payment", CreatePayment.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink5 = new RouterLink("Create receiver", CreateReceiver.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink6 = new RouterLink("Admin Panel", AdminPanel.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink7 = new RouterLink("Exchange currency", Exchange.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink8 = new RouterLink("Insurance", Insurance.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink9 = new RouterLink("Cards list", CardListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink10 = new RouterLink("Bonds list", BondListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink11 = new RouterLink("Credit list", CreditListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink12 = new RouterLink("Create card", CreateCard.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink13 = new RouterLink("Create bond", CreateBond.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink14 = new RouterLink("Create credit", CreateCredit.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());



        addToDrawer(new VerticalLayout(listLink,listLink2,
                listLink3,listLink4,listLink5,listLink6,listLink7,listLink8,
                listLink9,listLink10,listLink11,listLink12,
                listLink13,listLink14));
    }
}
