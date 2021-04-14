package com.darthlynx.algorithms.utils;

import java.io.*;
import java.net.URL;
import java.util.StringTokenizer;

public class TimusTemplateBufferedInputOutput {

    private static final String INPUT_FILE = "foo.txt";

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    public TimusTemplateBufferedInputOutput() {}
    public TimusTemplateBufferedInputOutput(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tokenizer = null;
    }

    public static void main(String[] args) {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = TimusTemplateBufferedInputOutput.class.getClassLoader().getResource(INPUT_FILE);
        try (Reader r = onlineJudge || inputLocation == null ? new InputStreamReader(System.in) : new FileReader(inputLocation.getPath());
             BufferedReader reader = new BufferedReader(r);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {

            new TimusTemplateBufferedInputOutput(reader, writer).solve();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void solve() {
        // do something here
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return tokenizer.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }
}
