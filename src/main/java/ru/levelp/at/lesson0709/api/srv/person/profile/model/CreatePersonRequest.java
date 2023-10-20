package ru.levelp.at.lesson0709.api.srv.person.profile.model;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.levelp.at.lesson0709.api.srv.person.profile.database.model.PersonEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePersonRequest {

    private static final Faker FAKER = new Faker();

    @Default
    private String role = "LECTOR";
    @Default
    private String email = FAKER.internet().emailAddress();
    @Default
    private String phoneNumber = FAKER.phoneNumber().cellPhone();
    private String placeOfWork;
    @Default
    private IdentityData identity = IdentityData.builder().build();
    private AddressData addressData;

    public CreatePersonResponse toCreatePersonResponse() {
        return CreatePersonResponse
            .builder()
            .data(PersonData
                .builder()
                .role(role)
                .email(email)
                .phoneNumber(phoneNumber)
                .placeOfWork(placeOfWork)
                .identity(identity)
                .addressData(addressData)
                .build())
            .build();
    }

    public PersonResponse toPersonResponse() {
        return PersonResponse
            .builder()
            .data(PersonData
                .builder()
                .role(role)
                .email(email)
                .phoneNumber(phoneNumber)
                .placeOfWork(placeOfWork)
                .identity(identity)
                .addressData(addressData)
                .build())
            .build();
    }

    public PersonEntity toPersonEntity() {
        return PersonEntity
            .builder()
            .role(role)
            .email(email)
            .phoneNumber(phoneNumber)
            .placeOfWork(placeOfWork)
            .firstName(identity.getFirstName())
            .build();
    }
}
