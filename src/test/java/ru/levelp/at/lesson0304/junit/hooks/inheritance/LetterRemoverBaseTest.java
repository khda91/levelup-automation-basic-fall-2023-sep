package ru.levelp.at.lesson0304.junit.hooks.inheritance;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.lesson0304.LetterRemover;

public abstract class LetterRemoverBaseTest {

    protected LetterRemover letterRemover;
    protected static List<String> list;

    @BeforeAll
    static void beforeAll() {
        System.out.printf("%s.beforeAll%n", LetterRemoverBaseTest.class.getName());
        list = List.of("sad", "bad", "small", "ssSSS", "South");
    }

    @BeforeEach
    void setUp() {
        System.out.printf("%s.setUp%n", this.getClass().getName());
        letterRemover = new LetterRemover();
    }

    @AfterEach
    void tearDown() {
        System.out.printf("%s.tearDown%n", this.getClass().getName());
        letterRemover = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.printf("%s.afterAll%n", LetterRemoverBaseTest.class.getName());
        list = null;
    }
}
