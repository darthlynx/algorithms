package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
public class FindAllPossibleRecipesFromGivenSupplies {

    // Time complexity: O(n * m + k)
    // Space complexity: O(n + k)
    // where k = supplies.length; n = recipes.length, m - total number of ingredients
    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            Set<String> available = new HashSet<>();
            for (String product : supplies) {
                available.add(product);
            }

            List<String> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < recipes.length; i++) {
                q.offer(i);
            }

            while (!q.isEmpty()) {
                int availableSize = available.size();
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {
                    int currentRecipe = q.poll();
                    List<String> ing = ingredients.get(currentRecipe);
                    if (canMake(ing, available)) {
                        available.add(recipes[currentRecipe]);
                        result.add(recipes[currentRecipe]);
                    } else {
                        q.offer(currentRecipe);
                    }
                }

                // cannot find new recepies
                if (availableSize == available.size()) {
                    break;
                }
            }
            return result;
        }

        private boolean canMake(List<String> ing, Set<String> available) {
            for (String i : ing) {
                if (!available.contains(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
