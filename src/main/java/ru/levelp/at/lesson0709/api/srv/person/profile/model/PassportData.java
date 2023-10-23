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
public class PassportData {
    private String series;
    private String number;
    private String placeOfIssue;
    private String dateOfIssue;
    private String departmentCode;
}
