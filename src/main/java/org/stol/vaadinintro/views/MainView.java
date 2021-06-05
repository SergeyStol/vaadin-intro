package org.stol.vaadinintro.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.concurrent.atomic.AtomicInteger;

@Route("")
@Theme(variant = Lumo.DARK)
public class MainView extends VerticalLayout {
    public MainView() {
        TextField textField = new TextField("Please, enter something and push the button");
        Button button = new Button("Push me");
        AtomicInteger counter = new AtomicInteger();
        button.addClickListener(event -> {
            Notification.show("You've entered: " + textField.getValue());
            Notification.show("Number of clicks: " + counter.incrementAndGet(),
                    5000, Notification.Position.BOTTOM_END);
            Notification.show("Number of clicks(from event): " + event.getClickCount(),
                    5000, Notification.Position.BOTTOM_END);
        });
        add(textField, button);
    }
}