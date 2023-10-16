package ru.levelp.at.lesson0709.api.serialization.deserialization;

import java.io.Serializable;

public class Cat implements Serializable {

    private String name;
    private String breed;
    private Integer age;

    @Override
    public String toString() {
        return "Cat{"
            + "name='" + name + '\''
            + ", breed='" + breed + '\''
            + ", age=" + age
            + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Integer getAge() {
        return age;
    }
}
