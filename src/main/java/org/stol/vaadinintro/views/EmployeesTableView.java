package org.stol.vaadinintro.views;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route("/table")
@Push
public class EmployeesTableView extends VerticalLayout {
    Grid<Employee> employeeGrid = new Grid<>(Employee.class);

    public EmployeesTableView() {
        var employee1 = Employee.of(1, "Name1", "Surname1", LocalDate.now());
        var employee2 = Employee.of(2, "Name2", "Surname2", LocalDate.now().plusDays(1));
        var employee3 = Employee.of(3, "Name1", "Surname2", LocalDate.now().plusDays(1));
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employeeGrid.setItems(employees);

        // configure columns
        employeeGrid.removeAllColumns();
        employeeGrid.addColumn(Employee::getId).setHeader("ID");
        employeeGrid.addColumn(Employee::getName).setHeader("NAME");
        employeeGrid.addColumn(Employee::getSurname).setHeader("SURNAME");

        // configure columns additional
        employeeGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        employeeGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS, GridVariant.LUMO_WRAP_CELL_CONTENT);

        // filters
        TextField textField = new TextField("Filter by name");
        textField.setPlaceholder("Name1");
        textField.setClearButtonVisible(true);
        textField.addValueChangeListener(e -> {
            if (textField.isEmpty())
                employeeGrid.setItems(employees);
            else
                employeeGrid.setItems(employees.stream().filter(employee ->
                        employee.getName().matches(".*" + textField.getValue() + ".*"))
                .collect(Collectors.toList()));
        });

        // combobox filter
        ComboBox<EmployeeFilters> comboBox = new ComboBox<>();
        add(textField, comboBox, employeeGrid);
        comboBox.setPlaceholder(EmployeeFilters.Name1.name());
        comboBox.setItems(EmployeeFilters.values());
        comboBox.setClearButtonVisible(true);
        comboBox.addValueChangeListener(e -> {
            if (comboBox.isEmpty())
                employeeGrid.setItems(employees);
            else
                employeeGrid.setItems(employees.stream().filter(employee ->
                        employee.getName().matches(".*" + comboBox.getValue() + ".*"))
                        .collect(Collectors.toList()));
        });
    }
}