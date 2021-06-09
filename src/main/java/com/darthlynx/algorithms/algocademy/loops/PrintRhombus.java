package com.darthlynx.algorithms.algocademy.loops;

public class PrintRhombus {

    public static void main(String[] args) {
        new PrintRhombus().printRhombus(5);
    }

    public void printRhombus(int n) {
        int stars = 1;
        int spaces = n/2;

        for (int i = 0; i <= n-1; i++) {
            System.out.println(buildRow(spaces, stars));
            if (i < n/2) {
                stars += 2;
                spaces -= 1;
            } else {
                stars -= 2;
                spaces += 1;
            }
        }
    }

    private String buildRow(int spaces, int stars) {
        String space = buildString(spaces, ' ');
        String star = buildString(stars, '*');
        return space + star + space;
    }

    private String buildString(int n, char character) {
        return String.valueOf(character).repeat(Math.max(0, n));
    }

}
