package com.darthlynx.algorithms.bytopic.trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordSearcher {

    private static final String INPUT_FILE = "words.txt";
    private static Random random = new Random();
    private List<String> foundWords = new ArrayList<>();

    static class TrieNode {
        private TrieNode[] children;
        private String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        prepareDictionary(root);

        char[][] field = generateField(5);
        for (char[] line : field) {
            System.out.println(Arrays.toString(line));
        }

        WordSearcher searcher = new WordSearcher();
        List<String> foundWords = searcher.search(field, root);
        System.out.println(foundWords);
    }

    public List<String> search(char[][] field, TrieNode root) {
        if (field == null || field.length == 0) {
            return foundWords;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                char ch = field[i][j];
                if (root.children[ch - 'a'] != null) {
                    dfs(field, i, j, root);
                }
            }
        }
        return foundWords;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char checked = '!';
        char ch = board[i][j];
        if (ch == checked || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        if (node.word != null) {
            foundWords.add(node.word);
            node.word = null; // mark as null to avoid words duplication
        }
        board[i][j] = checked;

        dfs(board, i-1, j, node); // check left neighbour
        dfs(board, i+1, j, node); // check right neighbour
        dfs(board, i, j-1, node); // check top neighbour
        dfs(board, i, j+1, node); // check bottom neighbour
        dfs(board, i+1, j-1, node); // check diagonal /
        dfs(board, i+1, j+1, node); // check diagonal \

        board[i][j] = ch;
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

    static void addWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.word = word;
    }

    static void prepareDictionary(TrieNode root) {
        var inputLocation = WordSearcher.class.getClassLoader().getResource(INPUT_FILE);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputLocation.getPath()))){
            while (true) {
                String currentLine = reader.readLine();
                if (currentLine == null || currentLine.isEmpty()) {
                    break;
                }
                addWord(root, currentLine);
            }
        } catch(IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

}
