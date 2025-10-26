package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/simple-bank-system/
public class SimpleBankSystem {

    // Time complexity: O(1) for each operation
    // Space complexity: O(n)
    class Bank {
        private final long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (isValidAccount(account1)
                    && isValidAccount(account2)
                    && isValidAmount(account1, money)) {
                withdraw(account1, money);
                deposit(account2, money);
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (isValidAccount(account)) {
                balance[account - 1] += money;
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if (isValidAccount(account) && isValidAmount(account, money)) {
                balance[account - 1] -= money;
                return true;
            }
            return false;
        }

        private boolean isValidAccount(int account) {
            return account >= 1 && account <= balance.length;
        }

        private boolean isValidAmount(int account, long money) {
            return balance[account - 1] >= money;
        }
    }

    /**
     * Your Bank object will be instantiated and called as such:
     * Bank obj = new Bank(balance);
     * boolean param_1 = obj.transfer(account1,account2,money);
     * boolean param_2 = obj.deposit(account,money);
     * boolean param_3 = obj.withdraw(account,money);
     */
}
