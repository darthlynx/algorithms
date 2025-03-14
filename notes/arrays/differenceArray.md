# difference array

#differenceArray #array #difference

**Difference Array** is a technique that allows efficiently applying range updates to an array in O(1) time per update, instead of modifying all elements within a range.

### Concept

Instead of updating all elements in a range `[left,right]`, we modify only the boundaries:

`diffArray[left] += value` - Increases all elements starting from left by value.
`diffArray[right + 1] -= value` - Negates that increase after right, ensuring that elements beyond right remain unaffected.

After processing all range updates, applying a prefix sum reconstructs the modified array in O(n) time.

### Example:

Problem: Add a given value to all elements in a range `[left,right]` for multiple queries.

```java
import java.util.*;

public class DifferenceArrayExample {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0}; // Initial array
        int[][] queries = {
            {1, 3, 2},  // Add 2 to range [1, 3]
            {2, 4, 3}   // Add 3 to range [2, 4]
        };

        applyQueries(nums, queries);
    }

    private static void applyQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diffArray = new int[n + 1];

        // Apply difference array technique
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int value = query[2];

            diffArray[left] += value;
            diffArray[right + 1] -= value;
        }

        // Compute prefix sum to reconstruct the modified array
        int[] result = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diffArray[i];
            result[i] = sum;
        }

        // Output the final array after applying all queries
        System.out.println(Arrays.toString(result));
    }
}
```

Output:
```text
[0, 2, 5, 5, 3]
```

Explanation:

First query `[1,3] += 2`:
`[0, 2, 2, 2, 0]`
Second query `[2,4] += 3`:
`[0, 2, 5, 5, 3]` (after computing prefix sum).

This technique efficiently processes range updates in O(1) per update and reconstructs the final array in O(n).