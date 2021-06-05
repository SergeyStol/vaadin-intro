package org.stol.vaadinintro.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;

public class MainView extends AppLayout {
    public MainView() {
        addToNavbar(new H1("Hello navbar"));
        addToDrawer(new H1("Hello drawer"));
    }
}