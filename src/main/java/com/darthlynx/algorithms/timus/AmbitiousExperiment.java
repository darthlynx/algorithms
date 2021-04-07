package com.darthlynx.algorithms.timus;

import com.darthlynx.algorithms.utils.TimusTemplateScanner;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class AmbitiousExperiment {
    private static final String INPUT_FILE = "2062_input.txt";

    int[] a;
    int[] b;
    int sqrtSize;

    public static void main(String[] args) {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = AmbitiousExperiment.class.getClassLoader().getResource(INPUT_FILE);
        try (Scanner input = (onlineJudge || inputLocation == null) ? new Scanner(System.in) : new Scanner(new File(inputLocation.getPath()))) {
            new AmbitiousExperiment().solve(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve(Scanner in) {
        int n = in.nextInt();

        int[] parts = new int[n+1];
        for (int i = 0; i < n; i++) {
            parts[i] = in.nextInt();
        }

        a = new int[n+1];
        sqrtSize = (int)(Math.sqrt(n) + 1);
        b = new int[sqrtSize+1];

        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int start = in.nextInt();
            int index;
            if (start == 1) {
                index = in.nextInt();
                System.out.println(a[index] + b[index/sqrtSize] + parts[index]);
            } else if (start == 2) {
                int l = in.nextInt(); // left
                int r = in.nextInt(); // right
                int d = in.nextInt(); // delta
                updateParts(l, r, d);
            }
        }

    }

    private void updateParts(int l, int r, int d) {
        int leftBlockPos = l/sqrtSize;
        int rightBlockPos = r/sqrtSize;

        if (leftBlockPos == rightBlockPos) {
            for (int i = l; i <= r; i++) {
                a[i] += d;
            }
        } else {
            int lR = (leftBlockPos+1) * sqrtSize;
            for (int i = l; i < lR; i++) {
                a[i] += d;
            }

            for (int i = leftBlockPos+1; i < rightBlockPos; i++) {
                b[i] += d;
            }

            int rL = rightBlockPos * sqrtSize;
            for (int i = rL; i <= r; i++) {
                a[i] += d;
            }
        }

    }

}
