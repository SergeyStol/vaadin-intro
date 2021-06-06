package org.stol.vaadinintro.views;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@AllArgsConstructor(staticName = "of", access = AccessLevel.PUBLIC)
@Data
public class Employee {
    Integer id;
    String name;
    String surname;
    LocalDate date;
}
