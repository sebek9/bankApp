package com.vaadin.tutorial.crm.ui.CreateFunctions;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.model.receiver.NewReceiver;
import com.vaadin.tutorial.crm.service.ReceiverService;
import com.vaadin.tutorial.crm.ui.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value="CreateReceiver", layout = MainLayout.class)
@PageTitle("Bank Application")
public class CreateReceiver extends FormLayout {

    private ReceiverService receiverService;

    private TextField name;
    private TextField surname;
    private TextField address;
    private Button button;

    @Autowired
    public CreateReceiver(ReceiverService receiverService){
        this.receiverService=receiverService;
        name = new TextField("Name");
        surname = new TextField("Surname");
        address = new TextField("Address");
        button = new Button("Sent");
        button.addClickListener(clickEvent->addReceiver());

        add(name);
        add(surname);
        add(address);
        add(button);

    }

    private void addReceiver() {
        NewReceiver receiver=new NewReceiver();
        receiver.setName(name.getValue());
        receiver.setSurname(surname.getValue());
        receiver.setAddress(address.getValue());
        receiverService.createdNewReceiver(receiver);
    }
}
