package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {

    // since nums contains the numbers in range [1,n] while the length of the nums is n+1
    // we may use the rabbit and tortoise approach to find the cycle in the loop
    // once we got the loop, we need to find the direct place where we have the loop started

    // imagine the example
    // nums    [1,2,1]
    // indexes  0 1 2

    // let's point slow and fast pointers to the first element's value: slow = fast = nums[0]
    // nums[0] = 1
    // now, let's loop over the values to find the place, where the fast and slow pointers met
    // slow index should come to nums[slow] position (nums[1] = 2 in our example)
    // while fast should make one more step at the time: fast = nums[nums[fast]] (nums[1] = 2; nums[2] = 1)
    // We need to continue this until we found the place where fast == slow (which means, that we found the cycle)

    // after that we have to point the slow pointer to the beginning of the array and make small steps for both pointers
    // once we found the place where they met again, we found the value of the repeated number.
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = slow;

        // set of steps for our example:
        //       0              1                   2 (got the cycle here!)
        // slow  nums[0] = 1  nums[1] = 2       nums[2] = 1
        // fast  nums[0] = 1  nums[nums[1]] = 1 nums[nums[1]] = 1
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        // set of steps here:
        //
        // slow nums[0] = 1
        // fast nums[nums[1]] = 1
        // since the value of both pointers are the same, we found the repeated value
        slow = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];

        }
        return slow;

    }

}
