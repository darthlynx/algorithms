package com.darthlynx.algorithms.timus;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://timus.online/problem.aspx?space=1&num=2062&locale=ru
public class AmbitiousExperiment {
    private static final String INPUT_FILE = "2062_input.txt";

    int[] particlesChargeDeltas;
    int[] sqrtBlocks;
    int sqrtSize;
    List<Integer>[] particlesDivisors;

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
        int n = in.nextInt(); // number of particles, 1 <= n <= 3*10^5

        particlesDivisors = calculateParticlesDivisors(n);

        int[] particlesCharges = new int[n+1];
        for (int i = 0; i < n; i++) {
            particlesCharges[i] = in.nextInt();
        }

        particlesChargeDeltas = new int[n+1];
        sqrtSize = (int)(Math.sqrt(n) + 1);
        sqrtBlocks = new int[sqrtSize+1];

        int q = in.nextInt(); // number of actions over particles, 1 <= q <= 3*10^5

        for (int i = 0; i < q; i++) {
            int start = in.nextInt();
            int index;
            if (start == 1) {
                index = in.nextInt() - 1; // because 1 <= n <= 3*10^5
                System.out.println(particlesChargeDeltas[index] + sqrtBlocks[index/sqrtSize] + particlesCharges[index]);
            } else if (start == 2) {
                int l = in.nextInt(); // left
                int r = in.nextInt(); // right
                int d = in.nextInt(); // delta
                updateParticlesCharges(l, r, d);
            }
        }

    }

    List<Integer>[] calculateParticlesDivisors(int n) {
        List<Integer>[] divisors = new List[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j+=i) {
                if (divisors[j] == null) {
                    divisors[j] = new ArrayList<>();
                }
                divisors[j].add(i);
            }
        }
        return divisors;
    }

    private void updateParticlesCharges(int leftBorder, int rightBorder, int delta) {
        int leftBlockPos = leftBorder/sqrtSize;
        int rightBlockPos = rightBorder/sqrtSize;

        // if left and right boarder are in the same sqrt block
        if (leftBlockPos == rightBlockPos) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                particlesChargeDeltas[i] += delta;
            }
        } else {
            updateLeftBlock(leftBorder, leftBlockPos, delta);
            updateBlocksBetweenLeftAndRight(leftBlockPos, rightBlockPos, delta);
            updateRightBlock(rightBorder, rightBlockPos, delta);
        }

    }

    private void updateLeftBlock(int leftBorder, int leftBlockPos, int d) {
        int rightBorderForLeftBlock = (leftBlockPos+1) * sqrtSize;
        for (int i = leftBorder; i < rightBorderForLeftBlock; i++) {
            particlesChargeDeltas[i] += d;
        }
    }

    private void updateRightBlock(int rightBorder, int rightBlockPos, int d) {
        int leftBorderForRightBlock = rightBlockPos * sqrtSize;
        for (int i = leftBorderForRightBlock; i <= rightBorder; i++) {
            particlesChargeDeltas[i] += d;
        }
    }

    private void updateBlocksBetweenLeftAndRight(int leftBlockPos, int rightBlockPos, int d) {
        for (int i = leftBlockPos+1; i < rightBlockPos; i++) {
            sqrtBlocks[i] += d;
        }
    }

}
