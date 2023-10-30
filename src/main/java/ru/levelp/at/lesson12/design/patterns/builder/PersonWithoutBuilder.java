package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;

public class PersonWithoutBuilder {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;

    public PersonWithoutBuilder(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public PersonWithoutBuilder(String lastName, String middleName, LocalDate dateOfBirth) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonWithoutBuilder(String firstName, LocalDate dateOfBirth, String middleName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonWithoutBuilder(String firstName, String lastName, String middleName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public static void main(String[] args) {
        var p1 = new PersonWithoutBuilder(null, "a", "1", LocalDate.now());
        var p2 = new PersonWithoutBuilder("a", null, "1", LocalDate.now());
        var p3 = new PersonWithoutBuilder("a", "1", null, LocalDate.now());
        var p4 = new PersonWithoutBuilder("a", "1", "n", null);
    }
}
