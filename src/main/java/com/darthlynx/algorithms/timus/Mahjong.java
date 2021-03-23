package com.darthlynx.algorithms.timus;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mahjong {

    private static final String INPUT_FILE = "2151_input.txt";
    private static final String TSUMO = "Tsumo";
    private static final String TENPAI = "Tenpai";
    private static final String NOTEN = "Noten";

    private static boolean isTenpai = false;

    public static void main(String[] args) {
        List<String> dice = Arrays.asList(getInputData().get(0).split(" "));

        // equality of chars first, then numbers
        // e.g. 1a, 2a, 3a, 1b, 2c...
        dice.sort((o1, o2) -> {
            if (o1.charAt(1) == o2.charAt(1)) {
                return Character.compare(o1.charAt(0), o2.charAt(0));
            } else {
                return Character.compare(o1.charAt(1),o2.charAt(1));
            }
        });

//        System.out.println(dice);

        backTracking(dice, 0, 0);
        if (isTenpai) {
            System.out.println(TENPAI);
        } else {
            System.out.println(NOTEN);
        }
    }


    private static void backTracking(List<String> dices, int triplesNumber, int pairNumber) {
        if (triplesNumber == 4 && pairNumber == 1) {
            System.out.println(TSUMO);
            System.exit(0);
        }
        if (triplesNumber < 4) {
            // check sequence triples
            for (int i = 0; i < dices.size(); i++) {
                int nextPos = getNext(dices, i);
                if (nextPos < 0) {
                    continue;
                }
                int nextNextPos = getNext(dices, nextPos);
                if (nextPos > i && nextNextPos > nextPos) {
                    String cur = dices.get(i);
                    String next = dices.get(nextPos);
                    String nextNext = dices.get(nextNextPos);

                    if (cur.charAt(0) + 1 == next.charAt(0) && next.charAt(0) + 1 == nextNext.charAt(0)) {
                        if (cur.charAt(1) == next.charAt(1) && next.charAt(1) == nextNext.charAt(1)) {
                            List<String> copy = new ArrayList<>(List.copyOf(dices));
                            copy.remove(nextNext);
                            copy.remove(next);
                            copy.remove(cur);
                            backTracking(copy, triplesNumber+1, pairNumber);
                        }
                    }
                }
            }
            // check triplet
            for (int i = 0; i < dices.size()-2; i++) {
                int nextPos = i+1;
                int nextNextPos = nextPos+1;

                String cur = dices.get(i);
                String next = dices.get(nextPos);
                String nextNext = dices.get(nextNextPos);

                if (cur.equals(next) && next.equals(nextNext)) {
                    List<String> copy = new ArrayList<>(List.copyOf(dices));
                    copy.remove(nextNext);
                    copy.remove(next);
                    copy.remove(cur);
                    backTracking(copy, triplesNumber+1, pairNumber);
                }
            }
        }
        // check pair
        if (pairNumber == 0) {
            for (int i = 0; i < dices.size()-1; i++) {
                String c = dices.get(i);
                if (c.equals(dices.get(i+1))) {
                    List<String> copy = new ArrayList<>(List.copyOf(dices));
                    copy.remove(i+1);
                    copy.remove(i);
                    backTracking(copy, triplesNumber, pairNumber+1);
                }
            }
        }

        if (triplesNumber == 4 && pairNumber == 0) {
            isTenpai = true;
        }
        if (triplesNumber == 3 && pairNumber == 1) {
            //
        }
    }

    private static int getNext(List<String> dices, int current) {
        String c = dices.get(current);
        for (int i = current+1; i < dices.size(); i++) {
            if (!dices.get(i).equals(c)) {
                return i;
            }
        }
        return -1;
    }



    private static List<String> getInputData() {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = Mahjong.class.getClassLoader().getResource(INPUT_FILE);
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
