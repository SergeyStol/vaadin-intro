package org.stol.vaadinintro.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Route("/api/data-provider")
@Push
public class GridWithDataProvider extends VerticalLayout {
    private final int SIZE = 10;
    private Grid<Employee> grid = new Grid<>(Employee.class);
    public GridWithDataProvider() {
        grid.setDataProvider(new ListDataProvider<>(getListEmployees()));
        add(grid);
    }

    private List<Employee> getListEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < SIZE; i++)
            employees.add(Employee.of(i, "Name" + i, "Surname" + i, LocalDate.now().plusDays(i)));
        return employees;
    }
}