package org.stol.vaadinintro.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.List;

@Route("/table")
@Push
public class EmployeesTableView extends VerticalLayout {
    public EmployeesTableView() {
        Grid<Employee> employeeGrid = new Grid<>(Employee.class);
        var employee1 = Employee.of(1, "Name1", "Surname1", LocalDate.now());
        var employee2 = Employee.of(2, "Name2", "Surname2", LocalDate.now().plusDays(1));
        employeeGrid.setItems(List.of(employee1, employee2));

        // configure columns
        employeeGrid.removeAllColumns();
        employeeGrid.addColumn(Employee::getId).setHeader("ID");
        employeeGrid.addColumn(Employee::getName).setHeader("NAME");
        employeeGrid.addColumn(Employee::getSurname).setHeader("SURNAME");

        add(employeeGrid);
    }
}