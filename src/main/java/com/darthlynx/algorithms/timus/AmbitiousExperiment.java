package com.darthlynx.algorithms.timus;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

// https://timus.online/problem.aspx?space=1&num=2062&locale=ru
public class AmbitiousExperiment {
    private static final String INPUT_FILE = "2062_input.txt";

    int[] particlesChargeDeltas;
    int[] sqrtBlocks;
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
        int n = in.nextInt(); // number of particles

        int[] particles = new int[n+1];
        for (int i = 0; i < n; i++) {
            particles[i] = in.nextInt();
        }

        particlesChargeDeltas = new int[n+1];
        sqrtSize = (int)(Math.sqrt(n) + 1);
        sqrtBlocks = new int[sqrtSize+1];

        int q = in.nextInt(); // number of actions over particles

        for (int i = 0; i < q; i++) {
            int start = in.nextInt();
            int index;
            if (start == 1) {
                index = in.nextInt();
                System.out.println(particlesChargeDeltas[index] + sqrtBlocks[index/sqrtSize] + particles[index]);
            } else if (start == 2) {
                int l = in.nextInt(); // left
                int r = in.nextInt(); // right
                int d = in.nextInt(); // delta
                updateParticlesCharges(l, r, d);
            }
        }

    }

    private void updateParticlesCharges(int l, int r, int d) {
        int leftBlockPos = l/sqrtSize;
        int rightBlockPos = r/sqrtSize;

        // if left and right boarder are in the same sqrt block
        if (leftBlockPos == rightBlockPos) {
            for (int i = l; i <= r; i++) {
                particlesChargeDeltas[i] += d;
            }
        } else {
            updateLeftBlock(l, leftBlockPos, d);
            updateBlocksBetweenLeftAndRight(leftBlockPos, rightBlockPos, d);
            updateRightBlock(r, rightBlockPos, d);
        }

    }

    private void updateLeftBlock(int l, int leftBlockPos, int d) {
        int rightBorderForLeftBlock = (leftBlockPos+1) * sqrtSize;
        for (int i = l; i < rightBorderForLeftBlock; i++) {
            particlesChargeDeltas[i] += d;
        }
    }

    private void updateRightBlock(int r, int rightBlockPos, int d) {
        int leftBorderForRightBlock = rightBlockPos * sqrtSize;
        for (int i = leftBorderForRightBlock; i <= r; i++) {
            particlesChargeDeltas[i] += d;
        }
    }

    private void updateBlocksBetweenLeftAndRight(int leftBlockPos, int rightBlockPos, int d) {
        for (int i = leftBlockPos+1; i < rightBlockPos; i++) {
            sqrtBlocks[i] += d;
        }
    }

}
