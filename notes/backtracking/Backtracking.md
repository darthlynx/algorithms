# Backtracking

#backtracking #recursion

Backtracking is a general algorithmic technique for solving problems recursively
by trying to build a solution incrementally and removing those solutions
that fail to satisfy the problem constraints at any point (i.e., *backtrack*).

## Key concepts
- **Recursive approach**: tries all possible options in a search space
- **Backtracking step**: when a partial solution violates constraints, undo the last decision
- **Pruning**: helms to eliminate branches early and optimize performance

## General algorithm
```pseudo
function backtrack(candidate):
    if candidate is a solution:
        add to results
        return
    for next_candidate in possible next steps:
        if is_valid(next_candidate):
            make_choice(next_candidate)
            backtrack(next_candidate)
            undo_choice(next_candidate)
```

## Use cases
Combinatorial problems:
- subset generation
- permutations and combinations
- Sudoku solver
- N-Queens problem
- Maze solver

## Example (subset generation)
```java
class Solution {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), subsets);

        // print all subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private void generateSubsets(int idx, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        if (idx >= nums.length) {
            // make a copy of current subset and add to solution
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // include element
        subset.add(nums[idx]);
        generateSubsets(idx + 1, nums, subset, subsets);

        // do not include element
        subset.remove(subset.size() - 1);
        generateSubsets(idx + 1, nums, subset, subsets);
    }
}
```

**Time complexity**: `O(N * 2^N)`
**Space complexity**: `O(N * 2^N)`

