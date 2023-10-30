package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PersonWithLombokBuilder {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
}
