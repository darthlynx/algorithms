package com.darthlynx.algorithms.timus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// https://timus.online/problem.aspx?space=1&num=1837&locale=ru
public class IsenbaevsNumber1837 {

    private static final String INPUT_FILE = "1837_input.txt";

    public static void main(String[] args) {
        List<String> inputs = getInputData();
        String isenbaev = "Isenbaev";

        int n = Integer.parseInt(inputs.get(0));


    }


    private static List<String> getInputData() {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        var inputLocation = IsenbaevsNumber1837.class.getClassLoader().getResource(INPUT_FILE);
        try (Reader r = onlineJudge || inputLocation == null ? new InputStreamReader(System.in) : new FileReader(inputLocation.getPath());
                BufferedReader reader = new BufferedReader(r)) {
            List<String> inputs = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                inputs.add(line);
            }
            return inputs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
