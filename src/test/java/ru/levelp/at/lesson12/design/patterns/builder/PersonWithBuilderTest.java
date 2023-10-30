package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class PersonWithBuilderTest {

    @Test
    void test() {
        var p1 = PersonWithBuilder.builder().build();
        var p2 = PersonWithBuilder.builder().firstName("a").build();
        var p3 = PersonWithBuilder.builder().lastName("a").build();
        var p4 = PersonWithBuilder.builder().firstName("b").lastName("a").middleName("c").build();
        var p5 = PersonWithBuilder.builder().firstName("b").lastName("a").dateOfBirth(LocalDate.now()).build();
    }
}
