# Boyer-Moore Majority Voting Algorithm

#majority #voting #array

## Overview

The Boyer-Moore Majority Voting Algorithm is an efficient algorithm used to find the majority element (an element that appears more than `n/2` times) in a sequence. It operates in O(n) time complexity and O(1) space complexity, making it optimal for this problem

## Algorithm Steps

1. Initialization: Set a candidate variable and a counter.
2. Candidate Selection Phase:
    - Iterate through the array.
    - If the counter is 0, set the current element as the candidate.
    - If the current element matches the candidate, increase the counter.
    - Otherwise, decrease the counter.
3. Verification Phase (Optional):
    - After finding the candidate, iterate again to verify if it truly appears more than `n/2` times.

 
## Example

```java
public class BoyerMooreMajority {
    public static int findMajorityElement(int[] nums) {
        int candidate = 0, count = 0;

        // Candidate selection
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verification step (optional)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        
        // Return -1 if no majority exists
        return (count > nums.length / 2) ? candidate : -1; 
    }
}
```

## Complexity Analysis

**Time Complexity:** O(n) (single pass for selection, optional second pass for verification)

**Space Complexity:** O(1) (only a few integer variables are used)


## Applications

1. **Voting systems:** Efficiently determining a dominant candidate.
2. **Data analysis:** Identifying frequently occurring elements in datasets.
3. **Consensus problems:** Finding the most common value in distributed systems.

## Limitations

Only works if a majority element exists. If an element appears more than `n/2` times, the algorithm guarantees finding it. Otherwise, the optional verification step is needed to confirm its presence.


## References

- [wiki](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm)