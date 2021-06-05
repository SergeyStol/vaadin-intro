package org.stol.vaadinintro.views.firstpage;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.stol.vaadinintro.views.main.MainView;

@Route(value = "", layout = MainView.class)
public class MyFirstPage extends VerticalLayout {
    public MyFirstPage() {
        add(new H1("Hello content area!"));
    }
}