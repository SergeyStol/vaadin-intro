package org.stol.vaadinintro.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@AllArgsConstructor(staticName = "of")
@Data
public class Employee {
    Integer id;
    String name;
    String surname;
    LocalDate date;
}
