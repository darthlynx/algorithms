package com.darthlynx.algorithms.timus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://acm.timus.ru/problem.aspx?space=1&num=2151&locale=ru
public class Mahjong {

    private static final String TSUMO = "Tsumo";
    private static final String TENPAI = "Tenpai";
    private static final String NOTEN = "Noten";

    private static boolean isTenpai = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahjong m = new Mahjong();
        m.solve(scanner.nextLine());
    }

    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 7c 1c 1c   - Tsumo
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 7c 1c 1b   - Tenpai (pair)
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 8c 6c 1c 1c   - Tenpai (triple)
    // 1a 2a 3a 6a 7a 8a 5b 5b 5b 9c 5c 3c 1c 1c   - Noten
    public void solve(String line) {
        List<String> dice = Arrays.asList(line.split(" "));

        // equality of chars first, then numbers
        // e.g. 1a, 2a, 3a, 1b, 2c...
        dice.sort((o1, o2) -> {
            if (o1.charAt(1) == o2.charAt(1)) {
                return Character.compare(o1.charAt(0), o2.charAt(0));
            } else {
                return Character.compare(o1.charAt(1),o2.charAt(1));
            }
        });

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
        if (triplesNumber == 3 && pairNumber == 1) {
            String first = dices.get(0);
            String second = dices.get(1);
            String third = dices.get(2);
            // for equal dices (triplet)
            if (first.equalsIgnoreCase(second) && second.equalsIgnoreCase(third)) {
                isTenpai = true;
            }
            // for sequence triples
            if (first.charAt(1) == second.charAt(1) && second.charAt(1) == third.charAt(1)) {
                if (second.charAt(0) - first.charAt(0) == 1 || third.charAt(0) - second.charAt(0) == 1) {
                    isTenpai = true;
                }
            }
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
                            List<String> copy = new ArrayList<>(dices);
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
                    List<String> copy = new ArrayList<>(dices);
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
                    List<String> copy = new ArrayList<>(dices);
                    copy.remove(i+1);
                    copy.remove(i);
                    backTracking(copy, triplesNumber, pairNumber+1);
                }
            }
        }

        if (triplesNumber == 4 && pairNumber == 0) {
            isTenpai = true;
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

}
