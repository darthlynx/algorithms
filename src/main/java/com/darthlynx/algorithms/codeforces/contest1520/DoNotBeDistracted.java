package com.darthlynx.algorithms.codeforces.contest1520;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://codeforces.com/contest/1520/problem/A
public class DoNotBeDistracted {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new DoNotBeDistracted().solve(scanner);
    }

    public void solve(Scanner scanner) {
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            printResult(!isDistracted(s));
            t--;
        }
    }

    private boolean isDistracted(String s) {
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch) && s.charAt(i-1) != ch) {
                return true;
            } else {
                set.add(ch);
            }
        }
        return false;
    }

    private void printResult(boolean hasConcerns) {
        System.out.println(hasConcerns ? "YES" : "NO");
    }
}
