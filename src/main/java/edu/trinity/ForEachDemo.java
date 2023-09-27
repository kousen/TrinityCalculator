package edu.trinity;

import java.nio.file.DirectoryStream;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> strings = List.of("one", "two", "three");
        System.out.println(strings);
        Predicate<String> stringFilter = (String s) -> s.length() % 2 == 0;
    }

}
