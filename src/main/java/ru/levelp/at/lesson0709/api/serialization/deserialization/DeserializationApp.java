package ru.levelp.at.lesson0709.api.serialization.deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationApp {

    public static void main(String[] args) {
        try (var ois = new ObjectInputStream(new FileInputStream("out.txt"))) {
            var cat = (Cat) ois.readObject();
            System.out.println(cat);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
