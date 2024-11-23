package com.darthlynx.algorithms.leetcode;


// https://leetcode.com/problems/rotating-the-box/
public class RotatingTheBox {

    // Time complexity: O(m*n^2)
    // Space complexity: O(m*n)
    class Solution1 {
        public char[][] rotateTheBox(char[][] box) {
            
            int m = box.length;
            int n = box[0].length;
    
            char[][] rotated = new char[n][m];
    
            for (int i = 0; i < m; i++) {
                for (int j = n - 2; j >= 0; j--) {
                    int k = j;
                    while (k < n-1) {
                        if (box[i][k] == '*' || box[i][k+1] == '*' || box[i][k+1] == '#') {
                            break;
                        }
                        char tmp = box[i][k+1];
                        box[i][k+1] = box[i][k];
                        box[i][k] = tmp;
                        k++;
                    }
                }
            }
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rotated[i][j] = box[m - j - 1][i];
                }
            }
    
            return rotated;
        }
    }
}
