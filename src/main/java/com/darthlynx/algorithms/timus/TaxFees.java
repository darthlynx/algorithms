package com.darthlynx.algorithms.timus;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class TaxFees {
    private long mxw;
    private long mxp;
    private long a;
    private long b;

    private static final String INPUT_FILE = "2152_input.txt";

    public static void main(String[] args) {
        List<String> inputs = getInputData();

        new TaxFees().solve(inputs);
    }

    public void solve(List<String> inputs) {
        String[] nk = getEntries(inputs.get(0));
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] params = getEntries(inputs.get(1));
        mxw = Long.parseLong(params[0]);
        mxp = Long.parseLong(params[1]);
        a = Long.parseLong(params[2]) * 100;
        b = Long.parseLong(params[3]);

        List<Holder> initialPairs = new ArrayList<>();
        List<Holder> updatedPairs = new ArrayList<>();
        for (int i = 2; i < n+2; i++) {
            String[] tmp = getEntries(inputs.get(i));
            Pair current = new Pair(Long.parseLong(tmp[0]), Long.parseLong(tmp[1]));
            initialPairs.add(new Holder(-1, calculateTaxes(current), current));

            Pair updatedW = new Pair(getMaxValue(current.w), current.p);
            Pair updatedP = new Pair(current.w, getMaxValue(current.p));
            long taxW = calculateTaxes(updatedW);
            long taxP = calculateTaxes(updatedP);
            if (taxW > taxP) {
                updatedPairs.add(new Holder(i-2, taxW, updatedW));
            } else {
                updatedPairs.add(new Holder(i-2, taxP, updatedP));
            }
        }


//        System.out.println(pairs);

        updatedPairs.sort((e1, e2) -> {
            // descending order by maxTax
            return Long.compare(e2.maxTax, e1.maxTax);
        });

//        System.out.println(holders);
//        List<Holder> resultList = new ArrayList<>(holders.subList(0, k));
//        System.out.println(resultList);

        for (int i = 0; i < k; i++) {
            Holder h = updatedPairs.get(i);
            initialPairs.set(h.index, h);
        }

//        BigDecimal resultTaxes = new BigDecimal(0);
        double resultTaxes = 0;
        for (int i = 0; i < initialPairs.size(); i++) {
//            resultTaxes = resultTaxes.add(new BigDecimal(initialPairs.get(i).maxTax));
            resultTaxes += initialPairs.get(i).maxTax;
        }

//        DecimalFormat format = new DecimalFormat(".#########");
//        System.out.println(format.format(resultTaxes.divide(new BigDecimal(100))));
        System.out.println(resultTaxes/100);
        initialPairs.forEach(e -> {
            System.out.println(e.pair);
        });


    }



    private long calculateTaxes(Pair pair) {
        long taxes = 0;
        if (pair.w > mxw) {
            taxes = (pair.w - mxw) * a;
        }
        if (pair.p > mxp) {
            taxes+= (pair.p - mxp) * b;
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
        long maxTax;
        Pair pair;

        public Holder(int index, long maxTax, Pair pair) {
            this.index = index;
            this.maxTax = maxTax;
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

    private static String[] getEntries(String s) {
        String[] entries = s.split(" ");
        return entries;
    }

    private static List<String> getInputData() {
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
        URL inputLocation = TaxFees.class.getClassLoader().getResource(INPUT_FILE);
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
