package edu.trinity.functional;

import java.util.*;

public class NewStyle {
    public static void main(String[] args) {
        Arrays.stream("this is a list of string".split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

    }
}
