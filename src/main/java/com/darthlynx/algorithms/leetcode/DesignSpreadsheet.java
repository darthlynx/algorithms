package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-spreadsheet/
public class DesignSpreadsheet {

    class Spreadsheet {

        // <address,value> pair
        private Map<String, Integer> address;

        public Spreadsheet(int rows) {
            address = new HashMap<>();
        }

        public void setCell(String cell, int value) {
            address.put(cell, value);
        }

        public void resetCell(String cell) {
            address.remove(cell);
        }

        public int getValue(String formula) {
            String[] elements = formula.substring(1, formula.length()).split("\\+");

            int value1 = getCellValue(elements[0]);
            int value2 = getCellValue(elements[1]);

            return value1 + value2;
        }

        private int getCellValue(String adr) {
            if (isNumber(adr)) {
                return Integer.valueOf(adr);
            }
            if (address.containsKey(adr)) {
                return address.get(adr);
            }
            return 0;
        }

        private boolean isNumber(String elem) {
            return Character.isDigit(elem.charAt(0));
        }
    }

    /**
     * Your Spreadsheet object will be instantiated and called as such:
     * Spreadsheet obj = new Spreadsheet(rows);
     * obj.setCell(cell,value);
     * obj.resetCell(cell);
     * int param_3 = obj.getValue(formula);
     */
}
