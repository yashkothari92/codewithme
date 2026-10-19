LC 128, Difficulty: **Medium**

Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

https://neetcode.io/problems/longest-consecutive-sequence/question

Input: nums = [2,20,4,10,3,4,5]

Output: 4

```java
public int longestConsecutive(int[] nums) {
  Set<Integer> set = new HashSet<>();
  for(int i=0; i<nums.length; i++){
      set.add(nums[i]);
  }  

  int maxLen = 0;

  for(int num : set) {
      if(!set.contains(num-1)) {
        int len = 1;
        while(set.contains(num+1)) {
          len++;
          num++;
        }
        maxLen = Math.max(len, maxLen);
      }
  }
  return maxLen;
}

```
