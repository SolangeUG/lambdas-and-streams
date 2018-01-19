package org.java.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Basic features of the Streams API.
 *
 * @author Speakjava (Simon Ritter)
 * @author Solange U. Gasengayire
 */
public class Lesson02 {

    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Tester method for our class
     * @param args command-line arguments
     */
    public static void main(String... args) throws IOException, URISyntaxException {
        Lesson02 homework = new Lesson02();
        homework.runExercises();
    }

    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException in case the needed file isn't found
     */
    private void runExercises() throws IOException, URISyntaxException {
        System.out.println("\nJDK 8 Lambdas and Streams MOOC Lesson 2");

        System.out.println("\nRunning exercise 1 solution...");
        exercise1();

        System.out.println("\n\nRunning exercise 2 solution...");
        exercise2();

        System.out.println("\n\nRunning exercise 3 solution...");
        exercise3();

        System.out.println("\n\nRunning exercise 4 solution...");
        exercise4();

        System.out.println("\n\nRunning exercise 5 solution...");
        exercise5();

        System.out.println("\n\nRunning exercise 6 solution...");
        exercise6();

        System.out.println("\n\nRunning exercise 7 solution...");
        exercise7();
    }

    /**
     * Exercise 1
     *
     * Create a new list with all the strings from original list converted to
     * lower case and print them out.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        /* YOUR CODE HERE */
        final List<String> result = new ArrayList<>();
        list.forEach(element -> result.add(element.toLowerCase()));
        result.forEach(element -> System.out.print(element + " "));
    }

    /**
     * Exercise 2
     *
     * Modify exercise 1 so that the new list only contains strings that have an
     * odd length.
     */
    private void exercise2() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        /* YOUR CODE HERE */
        final List<String> result = new ArrayList<>();
        list.stream()
                .filter(element -> element.length() % 2 != 0)
                .forEach(result::add);
        result.forEach(element -> System.out.print(element + " "));
    }

    /**
     * Exercise 3
     *
     * Join the second, third and forth strings of the list into a single string,
     * where each word is separated by a hyphen (-). Print the resulting string.
     */
    private void exercise3() {
        List<String> list = Arrays.asList(
                "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

        /* YOUR CODE HERE */
        final List<Integer> indices = Arrays.asList(1, 2, 3);
        String result = list.stream()
                .filter(element -> indices.contains(list.indexOf(element)))
                .collect(Collectors.joining("-"));
        System.out.print(result);
    }

    /**
     * Count the number of lines in the file using the BufferedReader provided
     */
    private void exercise4() throws IOException, URISyntaxException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("Sonnet.txt").toURI()),
                StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            System.out.print("Line count = " + reader.lines().count());
        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with
     * no duplicates contained in the file.  Print the words.
     *
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private void exercise5() throws IOException, URISyntaxException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("Sonnet.txt").toURI()),
                StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .forEach(word -> System.out.print(word + " "));
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from
     * the file, converted to lower-case and with duplicates removed, which is
     * sorted by natural order.  Print the contents of the list.
     */
    private void exercise6() throws IOException, URISyntaxException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("Sonnet.txt").toURI()),
                StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted()
                    .forEachOrdered(word -> System.out.print(word + " "));
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private void exercise7() throws IOException, URISyntaxException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("Sonnet.txt").toURI()),
                StandardCharsets.UTF_8)) {

            /* YOUR CODE HERE */
            reader.lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted(Comparator.comparingInt(String::length))
                    .forEach(word -> System.out.print(word + " "));
            System.out.println();
        }
    }

}
