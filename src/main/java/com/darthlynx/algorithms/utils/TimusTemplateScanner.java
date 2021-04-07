package com.darthlynx.algorithms.utils;

import com.darthlynx.algorithms.timus.TaxFees;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class TimusTemplateScanner {

    private static final String INPUT_FILE = "foo.txt";

    public static void main(String[] args) {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = TimusTemplateScanner.class.getClassLoader().getResource(INPUT_FILE);
        try (Scanner input = (onlineJudge || inputLocation == null) ? new Scanner(System.in) : new Scanner(new File(inputLocation.getPath()))) {
            new TimusTemplateScanner().solve(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve(Scanner in) {
        // paste a solution here
    }
}
