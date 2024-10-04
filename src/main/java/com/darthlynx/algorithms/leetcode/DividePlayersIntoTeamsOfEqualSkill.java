package com.darthlynx.algorithms.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
public class DividePlayersIntoTeamsOfEqualSkill {

    class Solution {
        
        public long dividePlayers(int[] skill) {
            Arrays.sort(skill);
            int left = 0;
            int right = skill.length-1;

            long teamSkill = skill[left] + skill[right];
            long chemistry = 0;
            while (left < right) {
                if ((long) skill[left] + skill[right] != teamSkill) {
                    return -1;
                }
                chemistry += (long) skill[left] * skill[right];
                left++;
                right--;
            }
            return chemistry;
        }
    }

}
