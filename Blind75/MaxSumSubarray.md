LC 53, Difficulty: **Medium**

Given an array of integers nums, find the subarray with the largest sum and return the sum.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [2,-3,4,-2,2,1,-1,4]

Output: 8

```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currSum = nums[0];

    for(int i=1; i<nums.length; i++){
        currSum = Math.max(nums[i], currSum+nums[i]);
        maxSum = Math.max(currSum, maxSum);
       // System.out.println("num="+nums[i]+", currSum="+currSum+", maxSum="+maxSum);
    }

    return maxSum;
}
```
