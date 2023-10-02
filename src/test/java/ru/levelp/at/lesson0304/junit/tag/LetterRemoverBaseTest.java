package ru.levelp.at.lesson0304.junit.tag;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson0304.LetterRemover;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class LetterRemoverBaseTest {

    protected static List<String> list;
    protected LetterRemover letterRemover;

    @BeforeAll
    void beforeAll() {
        System.out.printf("%s.beforeAll%n", this.getClass().getName());
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
    void afterAll() {
        System.out.printf("%s.afterAll%n", this.getClass().getName());
        list = null;
    }
}
