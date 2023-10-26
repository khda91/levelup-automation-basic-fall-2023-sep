package ru.levelp.at.lesson1011.cicd.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;

    private final Map<String, Object> context;

    private TestContext() {
        context = new HashMap<>();
    }

    public void add(String key, Object value) {
        context.put(key, value);
    }

    public Object get(String key) {
        return context.get(key);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
