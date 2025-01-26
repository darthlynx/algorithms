package com.darthlynx.algorithms.timus;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://timus.online/problem.aspx?space=1&num=2062
public class AmbitiousExperiment {
    private static final String INPUT_FILE = "2062_input.txt";

    long[] particlesChargeDeltas;
    long[] sqrtBlocks;
    int sqrtSize;
    List<Integer>[] particlesDivisors;

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    public AmbitiousExperiment() {}
    public AmbitiousExperiment(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.tokenizer = null;
    }

    public static void main(String[] args) {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = AmbitiousExperiment.class.getClassLoader().getResource(INPUT_FILE);
        try (Reader r = onlineJudge || inputLocation == null ? new InputStreamReader(System.in) : new FileReader(inputLocation.getPath());
             BufferedReader reader = new BufferedReader(r);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {

            new AmbitiousExperiment(reader, writer).solve();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void solve() {
        int n = nextInt(); // number of particles, 1 <= n <= 3*10^5

        particlesDivisors = calculateParticlesDivisors(n);

        int[] particlesCharges = new int[n+1];
        for (int i = 1; i <= n; i++) {
            particlesCharges[i] = nextInt();
        }

        particlesChargeDeltas = new long[n+1];
        sqrtSize = (int)(Math.sqrt(n) + 1);
        sqrtBlocks = new long[sqrtSize+1];

        int q = nextInt(); // number of actions over particles, 1 <= q <= 3*10^5

        int index, leftBound, rightBound, deltaCharge;
        for (int i = 0; i < q; i++) {
            int start = nextInt();
            if (start == 1) {
                index = nextInt();
                this.writer.println(calculateParticleCharge(particlesCharges, index));
            } else if (start == 2) {
                leftBound = nextInt();
                rightBound = nextInt();
                deltaCharge = nextInt();
                updateParticlesCharges(leftBound, rightBound, deltaCharge);
            }
        }

    }

    long calculateParticleCharge(int[] particlesCharges, int index) {
        long result = particlesCharges[index];
        List<Integer> divisors = particlesDivisors[index];
        for (int i = 0; i < divisors.size(); i++) {
            result += particlesChargeDeltas[divisors.get(i)] + sqrtBlocks[divisors.get(i)/sqrtSize];
        }
        return result;
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
