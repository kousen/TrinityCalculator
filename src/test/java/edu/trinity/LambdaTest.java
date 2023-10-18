package edu.trinity;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class LambdaTest {
    private final List<String> strings = List.of("this", "is", "a", "list", "of", "strings");

    @Test
    void streamOfStrings() {
        strings.stream()
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<String> up = strings.stream()
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(up);
    }

    @Test
    void useConsumerInForEach() {
        strings.forEach(s -> System.out.println("The value is " + s));
        strings.forEach(System.out::println);
    }

    @Test
    void useBiConsumerWithForEach() {
        BiConsumer<String, Integer> biConsumer = (k, v) -> System.out.println(k + " -> " + v);
        Map.ofEntries(Map.entry("one", 1), Map.entry("two", 2), Map.entry("three", 3))
                .forEach(biConsumer);
    }

}
