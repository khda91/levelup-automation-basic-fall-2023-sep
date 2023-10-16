package ru.levelp.at.lesson0709.api.srv.person.profile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePersonRequest {

    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;
    private IdentityData identity;
    private AddressData addressData;
}
