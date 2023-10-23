package ru.levelp.at.lesson0709.api.srv.person.profile.database.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class PersonEntity {

    private UUID id;
    private String email;
    private String phoneNumber;
    private String role;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String placeOfWork;
    private String passportSeries;
    private String passportNumber;
    private String placeOfIssue;
    private String dateOfIssue;
    private String departmentCode;
    private String street;
    private String houseNumber;
    private String houseBuilding;
    private String houseLetter;
    private String flat;
    private String city;
    private String postalCode;

    public static RowMapper<PersonEntity> mapper() {
        return new BeanPropertyRowMapper<>(PersonEntity.class);
    }
}
