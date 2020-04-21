package com.vaadin.tutorial.crm.ui.CreateFunctions;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.bond.NewBond;
import com.vaadin.tutorial.crm.service.BondService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="CreateBond", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CreateBond extends FormLayout {

    private BondService bondService;


    private TextField issuer;
    private IntegerField units;
    private TextField unitValue;
    private Button button;

    @Autowired
    public CreateBond(BondService bondService){
        this.bondService=bondService;
        issuer = new TextField("Issuer");
        units = new IntegerField("Units");
        unitValue = new TextField("Unit value");
        button = new Button("Sent");
        button.addClickListener(clickEvent->addBond());

        add(issuer);
        add(units);
        add(unitValue);
        add(button);

    }

    private void addBond() {
        NewBond bond=new NewBond();
        bond.setIssuer(issuer.getValue());
        bond.setUnits(units.getValue());
        bond.setUnitValue(unitValue.getValue());
        bondService.createdNewBond(bond);
    }


}
