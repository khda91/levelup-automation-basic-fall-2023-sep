package ru.levelp.at.lesson0709.api.srv.person.profile.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class PersonData {

    private String id;
    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;
    private IdentityData identity;
    @JsonProperty("address")
    private AddressData addressData;
}
