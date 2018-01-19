package org.java.training;

import java.util.*;

/**
 * Lambda Expressions and Method References
 *
 * @author Speakjava (Simon Ritter)
 * @author Solange U. Gasengayire
 */
public class Lesson01 {

    /**
     * Tester method for our class
     * @param args command-line arguments
     */
    public static void main(String... args) {
        Lesson01 homework = new Lesson01();
        homework.runExercises();
    }

    /**
     * Run the exercises to ensure we got the right answers
     */
    private void runExercises() {
        System.out.println("\nJDK 8 Lambdas and Streams MOOC Lesson 1");

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
    }

    /*
     * All exercises should be completed using Lambda expressions and the new
     * methods added to JDK 8 where appropriate. There is no need to use an
     * explicit loop in any of the code. Use method references rather than full
     * lambda expressions wherever possible.
     */

    /**
     * Exercise 1
     *
     * Create a string that consists of the first letter of each word in the list
     * of Strings provided.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

        /* YOUR CODE HERE */
        final StringBuilder result = new StringBuilder();
        list.forEach(element -> result.append(element.charAt(0)));
        System.out.print(result);
    }

    /**
     * Exercise 2
     *
     * Remove the words that have odd lengths from the list.
     */
    private void exercise2() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        /* YOUR CODE HERE */
        list.removeIf(element -> element.length() % 2 != 0);
        list.forEach(System.out::print);
    }

    /**
     * Exercise 3
     *
     * Replace every word in the list with its upper case equivalent.
     */
    private void exercise3() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        /* YOUR CODE HERE */
        list.forEach(element -> System.out.print(element.toUpperCase() + " "));
    }

    /**
     * Exercise 4
     *
     * Convert every key-value pair of the map into a string and append them all
     * into a single string, in iteration order.
     */
    private void exercise4() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);

        /* YOUR CODE HERE */
        final StringBuilder result = new StringBuilder();
        map.forEach((key, value) -> result.append(key).append(value));
        System.out.print(result);
    }

    /**
     * Exercise 5
     *
     * Create a new thread that prints the numbers from the list.
     */
    private void exercise5() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /* YOUR CODE HERE */
        new Thread(() -> list.forEach(element -> System.out.print(element + " "))).start();
    }

}
