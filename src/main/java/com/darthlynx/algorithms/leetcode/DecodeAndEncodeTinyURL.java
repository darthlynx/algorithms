package com.darthlynx.algorithms.leetcode;

import java.util.*;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class DecodeAndEncodeTinyURL {

    public static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static char[] allowedCharacters = ALLOWED_CHARACTERS.toCharArray();
    private static Map<Character, Integer> charToIndexTable;
    private static Map<Long, String> storage;
    private long uniqueId = 0L;

    public DecodeAndEncodeTinyURL() {
        charToIndexTable = constructCharToIndexTable();
        storage = new HashMap<>();
    }

    private Map<Character, Integer> constructCharToIndexTable() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < allowedCharacters.length; i++) {
            map.put(allowedCharacters[i], i);
        }
        return map;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long id = getNextId();
        storage.put(id, longUrl);
        return createUniqueId(id);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        long id = getStorageIdByShortURL(shortUrl);
        return storage.get(id);
    }

    String createUniqueId(long id) {
        List<Integer> base62 = convertBase10toBase62Id(id);
        StringBuilder builder = new StringBuilder();
        for(Integer index : base62) {
            char ch = allowedCharacters[index];
            builder.append(ch);
        }
        return builder.toString();
    }

    private List<Integer> convertBase10toBase62Id(long id) {
        LinkedList<Integer> base62Digits = new LinkedList<>();
        while (id > 0) {
            int reminder = (int)(id % 62);
            base62Digits.addFirst(reminder);
            id /= 62;
        }
        return base62Digits;
    }

    long getStorageIdByShortURL(String shortURL) {
        long id = 0L;
        int exp = shortURL.length() - 1;

        for (char c : shortURL.toCharArray()) {
            int base10 = charToIndex(c);
            id += (base10 * Math.pow(62, exp));
            exp--;
        }
        return id;
    }

    private int charToIndex(char c) {
        return charToIndexTable.get(c);
    }

    private long getNextId() {
        return uniqueId++;
    }

}
