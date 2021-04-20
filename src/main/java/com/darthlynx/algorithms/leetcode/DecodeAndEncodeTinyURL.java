package com.darthlynx.algorithms.leetcode;

import java.util.*;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class DecodeAndEncodeTinyURL {

    public static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final char[] allowedCharacters = ALLOWED_CHARACTERS.toCharArray();
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
        return createBase62UniqueID(id);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        long id = getStorageIdByShortURL(shortUrl);
        return storage.get(id);
    }

    String createBase62UniqueID(long id) {
        return convertBase10toBase62Id(id);
    }

    private String convertBase10toBase62Id(long id) {
        StringBuilder builder = new StringBuilder();
        while (id > 0) {
            int reminder = (int)(id % 62);
            builder.append(allowedCharacters[reminder]);
            id /= 62;
        }
        return builder.reverse().toString();
    }

    long getStorageIdByShortURL(String shortURL) {
        long id = 0L;
        int length = shortURL.length() - 1;

        for (char c : shortURL.toCharArray()) {
            int base10 = charToIndex(c);
            id += (base10 * Math.pow(62, length));
            length--;
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
