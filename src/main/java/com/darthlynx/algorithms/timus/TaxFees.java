package com.darthlynx.algorithms.timus;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

// https://acm.timus.ru/problem.aspx?space=1&num=2152
public class TaxFees {
    private long mxw;
    private long mxp;
    private long a;
    private long b;

    private static final String INPUT_FILE = "2152_input.txt";

    public static void main(String[] args) {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = TaxFees.class.getClassLoader().getResource(INPUT_FILE);
        try (Scanner input = (onlineJudge || inputLocation == null) ? new Scanner(System.in) : new Scanner(new File(inputLocation.getPath()))) {
            new TaxFees().solve(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve(Scanner in) {
        int n = in.nextInt(); // number of packages
        int k = in.nextInt(); // number of possible changes

        mxw = in.nextInt();       // max weight
        mxp = in.nextInt();       // max price
        a = in.nextInt() * 100L;  // overweight tax (one per each extra kg)
        b = in.nextInt();         // overprice tax (%)

        List<Holder> initialPairs = new ArrayList<>();
        List<Holder> updatedPairs = new ArrayList<>();

        Pair current, updatedW, updatedP;
        Holder currentHolder;
        BigDecimal cur, taxW, taxP, deltaW, deltaP;
        for (int i = 2; i < n+2; i++) {
            current = new Pair(in.nextLong(), in.nextLong());
            currentHolder = new Holder(-1, calculateTaxes(current), new BigDecimal(0), current);
            initialPairs.add(currentHolder);
            cur = currentHolder.maxTax;

            updatedW = new Pair(getMaxValue(current.w), current.p);
            updatedP = new Pair(current.w, getMaxValue(current.p));
            taxW = calculateTaxes(updatedW);
            taxP = calculateTaxes(updatedP);
            deltaW = taxW.subtract(cur);
            deltaP = taxP.subtract(cur);
            if (deltaW.compareTo(deltaP) > 0) {
                updatedPairs.add(new Holder(i-2, taxW, deltaW, updatedW));
            } else {
                updatedPairs.add(new Holder(i-2, taxP, deltaP, updatedP));
            }
        }


        updatedPairs.sort((e1, e2) -> {
            // descending order by taxDelta
            return e2.taxDelta.compareTo(e1.taxDelta);
        });

        for (int i = 0; i < k; i++) {
            Holder h = updatedPairs.get(i);
            initialPairs.set(h.index, h);
        }

        BigDecimal resultTaxes = new BigDecimal(0);
        for (Holder initialPair : initialPairs) {
            resultTaxes = resultTaxes.add(initialPair.maxTax);
        }

        // print results
        DecimalFormat format = new DecimalFormat(".000000000");
        System.out.println(format.format(resultTaxes.divide(new BigDecimal(100L))));
        initialPairs.forEach(e -> System.out.println(e.pair));
    }

    private BigDecimal calculateTaxes(Pair pair) {
        BigDecimal taxes = new BigDecimal(0);
        BigDecimal diff;
        if (pair.w > mxw) {
            diff = new BigDecimal(pair.w).subtract(new BigDecimal(mxw));
            taxes = taxes.add(diff.multiply(new BigDecimal(a)));
        }
        if (pair.p > mxp) {
            diff = new BigDecimal(pair.p).subtract(new BigDecimal(mxp));
            taxes = taxes.add(diff.multiply(new BigDecimal(b)));
        }
        return taxes;
    }

    private static long getMaxValue(long value) {
        String val = String.valueOf(value);
        StringBuilder builder = new StringBuilder(val);

        // change only one digit to get the max number
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) < '9') {
                builder.setCharAt(i, '9');
                break;
            }
        }
        return Long.parseLong(builder.toString());
    }

    static class Holder {
        int index;
        BigDecimal maxTax;
        BigDecimal taxDelta;
        Pair pair;

        public Holder(int index, BigDecimal maxTax, BigDecimal taxDelta, Pair pair) {
            this.index = index;
            this.maxTax = maxTax;
            this.taxDelta = taxDelta;
            this.pair = pair;
        }

        @Override
        public String toString() {
            return maxTax + " " + pair;
        }
    }

    static class Pair {
        long w;
        long p;

        public Pair(long w, long p) {
            this.w = w;
            this.p = p;
        }

        @Override
        public String toString() {
            return String.format("%d %d", w, p);
        }
    }

}
