package com.darthlynx.algorithms.leetcode;

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        // index to traverse over the key
        int keyPointer = 0;
        int k = key.length();
        
        // number of movements required to spell a key word
        int res = 0;

        int n = ring.length();
        int ringPos = 0; // current position of ring        

        while (keyPointer < k) {
            char currentKeyChar = key.charAt(keyPointer);

            if (currentKeyChar == ring.charAt(ringPos)) {
                res++;
                keyPointer++;
                continue; // since current char is found, we move keyPointer to find another character
            }

            // else we look for the closest position of the char in both directions

            int rightRingPos;
            int leftRingPos;
            
            // example:
            // ring: godding, currentKeyChar == d 
            //           ^

            int rightSearchSteps = 0;
            int rightOccurance = ring.indexOf(currentKeyChar, ringPos);
            if (rightOccurance == -1) { // if no occurrence of character on the right hand side
                // search from the beginning and add the index position + number of steps from ringPos to the end of the ring
                rightRingPos = ring.indexOf(currentKeyChar);
                rightSearchSteps = rightRingPos + (n - ringPos);
            } else {
                rightSearchSteps = rightOccurance - ringPos;
                rightRingPos = rightOccurance;
            }


            int leftSearchSteps = 0;
            int leftOccurance = ring.lastIndexOf(currentKeyChar, ringPos);
            if (leftOccurance == -1) { // if no occurrences on the left, we failover to the end of the ring and start searching there
                leftOccurance = ring.lastIndexOf(currentKeyChar);
                leftRingPos = leftOccurance;
                leftSearchSteps = n - leftOccurance + ringPos;
            } else {
                // number of steps will be diff between indexes
                leftRingPos = leftOccurance;
                leftSearchSteps = ringPos - leftOccurance;
            }

            // check which way is shorter and move there
            if (leftSearchSteps < rightSearchSteps) {
                res += leftSearchSteps + 1; // +1 to click the button
                ringPos = leftRingPos;
            } else {
                res += rightSearchSteps + 1; // +1 to click the button
                ringPos = rightRingPos;
            }
            keyPointer++;
        }


        return res;
    }
}
