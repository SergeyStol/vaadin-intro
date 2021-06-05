package org.stol.vaadinintro.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.communication.PushMode;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

@Route("")
@Theme(variant = Lumo.DARK)
@Push
public class MainView extends VerticalLayout {

    Label label = new Label();

    public MainView() {
        TextField textField = new TextField("Please, enter something and push the button");
        Button button = new Button("Push me");
        AtomicInteger counter = new AtomicInteger();
        label.setText("I am a label");
        button.addClickListener(event -> {
            Notification.show("You've entered: " + textField.getValue());
            Notification.show("Number of clicks: " + counter.incrementAndGet(),
                    5000, Notification.Position.BOTTOM_END);
            Notification.show("Number of clicks(from event): " + event.getClickCount(),
                    5000, Notification.Position.BOTTOM_END);
            label.setText(String.valueOf(counter.get()));
        });
        add(textField, button, label);
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
    public void changeLabelValue() {
//        label.setText(String.valueOf(0));  It doesn't work
        getUI().ifPresent(ui -> {
            ui.access(() -> {
                label.setText(String.valueOf(0));
            });
        });
    }
}