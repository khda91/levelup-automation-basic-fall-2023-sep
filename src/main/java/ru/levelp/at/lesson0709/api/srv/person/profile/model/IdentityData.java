package ru.levelp.at.lesson0709.api.srv.person.profile.model;

import com.github.javafaker.Faker;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class IdentityData {

    private static final Faker FAKER = new Faker();

    @Default
    private String firstName = FAKER.name().firstName();
    @Default
    private String lastName = FAKER.name().lastName();
    @Default
    private String middleName = FAKER.name().nameWithMiddle().split(" ")[1];
    private String gender;
    @Default
    private String dateOfBirth = FAKER.date().birthday().toInstant()
                                      .atZone(ZoneId.systemDefault()).toLocalDate().toString();
    private String placeOfBirth;
    private PassportData passport;
}
