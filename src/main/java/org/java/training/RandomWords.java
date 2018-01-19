package org.java.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 *
 * @author Speakjava (Simon Ritter)
 * @author Solange U. Gasengayire
 */
public class RandomWords {
    private final List<String> sourceWords;

    /**
     * Constructor
     *
     * @throws IOException If the source words file cannot be read
     * @throws URISyntaxException If the source words file URI is incorrect
     */
    RandomWords() throws IOException, URISyntaxException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("Words.txt").toURI()))) {

            // YOUR CODE HERE
            sourceWords = reader.lines()
                    .collect(Collectors.toList());

            System.out.println("Loaded " + sourceWords.size() + " words");
        }
    }

    /**
     * Create a list of a given size containing random words
     *
     * @param listSize The size of the list to create
     * @return The created list
     */
    public List<String> createList(int listSize) {
        Random rand = new Random();

        // YOUR CODE HERE
        List<String> wordList = new ArrayList<>(listSize);
        rand.ints(listSize)
                .forEach(r -> {
                    if (r > 0 && r < wordList.size())
                        wordList.add(new ArrayList<>(sourceWords).get(r));
                });

        return wordList;
    }

    /**
     * Return the list of all source words, which cannot be modified
     *
     * @return The unmodifiable list of all source words
     */
    public List<String> allWords() {
        return Collections.unmodifiableList(sourceWords);
    }
}
