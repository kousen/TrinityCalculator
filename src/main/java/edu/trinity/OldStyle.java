package edu.trinity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OldStyle {
    public static void main(String[] args) {
        String[] words = "this is a list of string".split("\\s+");

        // Find words of even length
        List<String> evens = new ArrayList<>();
        for (String word : words) {
            // Change them to uppercase
            if (word.length() % 2 == 0) {
                evens.add(word.toUpperCase());
            }
        }
        System.out.println(evens);

        // Sort them by length
        Collections.sort(evens, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // Print the results
        System.out.println(evens);

    }
}
