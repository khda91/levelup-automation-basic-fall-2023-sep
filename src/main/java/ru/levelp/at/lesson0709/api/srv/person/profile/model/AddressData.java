package ru.levelp.at.lesson0709.api.srv.person.profile.model;

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
public class AddressData {

    private String street;
    private String houseNumber;
    private String houseBuilding;
    private String houseLetter;
    private String flat;
    private String city;
    private String postalCode;
}
