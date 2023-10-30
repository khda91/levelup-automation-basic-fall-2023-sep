package ru.levelp.at.lesson12.design.patterns.steps.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserModel {

    private final String name;
    private final String email;
    private final String password;
}
