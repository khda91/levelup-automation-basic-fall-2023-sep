package ru.levelp.at.lesson0304;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterRemover {

    public List<String> remove(List<String> list, String letter) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        if (letter == null || letter.isBlank()) {
            throw new IllegalArgumentException("letter cannot be null or empty");
        }

        return list.stream()
                .map(str -> str.replaceAll(letter.toLowerCase() + "|" + letter.toUpperCase(), ""))
                .collect(Collectors.toList());
    }

    public List<String> removeVanila(List<String> list, String letter) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        if (letter == null || letter.isBlank()) {
            throw new IllegalArgumentException("letter cannot be null or empty");
        }

        List<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(str.replaceAll(letter.toLowerCase() + "|" + letter.toUpperCase(), ""));
        }

        return result;
    }
}
