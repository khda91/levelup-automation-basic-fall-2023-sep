package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;

public class PersonWithBuilder {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;

    public PersonWithBuilder(String firstName, String lastName, String middleName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String middleName;
        private LocalDate dateOfBirth;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonWithBuilder build() {
            return new PersonWithBuilder(firstName, lastName, middleName, dateOfBirth);
        }
    }
}
