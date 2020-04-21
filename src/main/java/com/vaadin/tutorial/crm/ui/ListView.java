package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="", layout = MainLayout.class)
//
@PageTitle("Bank Application")
public class ListView extends FormLayout {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    private Grid<ListView> grid = new Grid<>(ListView.class);



    public ListView(){



        button1=new Button("1");
        button2=new Button("2");
        button3=new Button("3");
        button4=new Button("4");
        button5=new Button("5");

        /*
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
*/
        add(new HorizontalLayout(button1,button2,button3,button4,button5));

    }

    /*
    public ListView(@Autowired GreetService service) {

        TextField textField = new TextField("Your name");

        Button button = new Button("Say hello",
                e -> Notification.show(service.greet(textField.getValue())));

        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        button.addClickShortcut(Key.ENTER);

        addClassName("centered-content");
        add(new H1("Hello world"),textField, button);
    }
*/
}
