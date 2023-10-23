package ru.levelp.at.lesson0709.api.serialization.deserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationApp {

    public static void main(String[] args) {
        var cat = new Cat();
        cat.setName("Vaska");
        cat.setBreed("Dvorovyi");
        cat.setAge(4);

        try (var oos = new ObjectOutputStream(new FileOutputStream("out.txt"))) {
            oos.writeObject(cat);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
