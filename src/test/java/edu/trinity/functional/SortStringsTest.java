package edu.trinity.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortStringsTest {
    private final String[] strings = "this is a list of strings".split("\\s+");

    @Test
    void defaultSort() {
        Arrays.stream(strings)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void sortByLength() {
        List<String> sortedStrings = Arrays.stream(strings)
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();

        assertThat(sortedStrings).containsExactly(
                "a", "is", "of", "list", "this", "strings"
        );
    }
}
