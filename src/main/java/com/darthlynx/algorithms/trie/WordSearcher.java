package com.darthlynx.algorithms.trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WordSearcher {

    private static final String INPUT_FILE = "words.txt";
    private static Random random = new Random();

    public static void main(String[] args) {
        Trie prefixTree = new Trie();
        prepareDictionary(prefixTree);

        char[][] field = generateField(5);
        for (char[] line : field) {
            System.out.println(Arrays.toString(line));
        }

        WordSearcher searcher = new WordSearcher();
        List<String> foundWords = searcher.search(field, prefixTree);
        System.out.println(foundWords);
    }

    public List<String> search(char[][] field, Trie dictionary) {
        return Collections.emptyList();
    }


    public static char[][] generateField(int size) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = getRandomChar();
            }
        }
        return field;
    }

    private static char getRandomChar() {
        return (char)(random.nextInt(26) + 'a');
    }

    private static void prepareDictionary(Trie trie) {
        var inputLocation = WordSearcher.class.getClassLoader().getResource(INPUT_FILE);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputLocation.getPath()))){
            while (true) {
                String currentLine = reader.readLine();
                if (currentLine == null || currentLine.isEmpty()) {
                    break;
                }
                trie.insert(currentLine);
            }
        } catch(IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

}
