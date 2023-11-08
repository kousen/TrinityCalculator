package edu.trinity.functional;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("DuplicatedCode")
public class ProcessDictionary {
    private final Path dictionary = Path.of("src/main/resources/dict/words");

    int maxLength() {
        try (Stream<String> words = Files.lines(dictionary)) {
//            return words.mapToInt(String::length).max().orElse(0);
            return words.max(Comparator.comparingInt(String::length)).orElse("").length();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void printTenLongestWords() {
        System.out.println("\nTen Longest Words:");
        int maxForFilter = maxLength() - 10;
        try (Stream<String> words = Files.lines(dictionary)) {
            words.filter(s -> s.length() > maxForFilter)
                    .sorted(Comparator.comparingInt(String::length).reversed()
                            //.thenComparing(Comparator.reverseOrder()))
                    )
                    .limit(10)
                    .forEach(w -> System.out.printf("%s (%d)%n".formatted(w, w.length())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printWordsOfEachLength() {
        System.out.println("\nList of words of each length:");
        int maxForFilter = maxLength() - 5;
        try (var words = Files.lines(dictionary)) {
            words.filter(s -> s.length() > maxForFilter)
                    .collect(Collectors.groupingBy(String::length)) // Map<Integer,List<String>>
                    .forEach((len, wordList) -> System.out.println(len + ": " + wordList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printHowManyWordsOfEachLength() {
        System.out.println("\nNumber of words of each length:");
        try (Stream<String> lines = Files.lines(dictionary)) {
            lines.filter(s -> s.length() > 20)
                    .collect(Collectors.groupingBy(String::length,
                            Collectors.counting())) // Map<Integer,Long>
                    .forEach((len, num) -> System.out.printf("%d: %d%n", len, num));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ProcessDictionary processDictionary = new ProcessDictionary();
        processDictionary.printTenLongestWords();
        processDictionary.printWordsOfEachLength();
        processDictionary.printHowManyWordsOfEachLength();
    }
}
