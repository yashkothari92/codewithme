LC#1, Difficulty: **Easy**

Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
[https://neetcode.io/problems/two-integer-sum/question?list=blind75](https://neetcode.io/problems/two-integer-sum/question?list=blind75)

Input:  nums = [3,4,5,6], target = 7
Output: [0,1]

Solution:
```java
public static void main(String[] args) {

        List<Integer> nums = List.of(1,3,4,2);
        int target = 6;

        int[] bothNums = findTwoSums(nums, target);
        System.out.println(bothNums[0]+","+bothNums[1]);
    }

    private static int[] findTwoSums(List<Integer> nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++) {
            if(map.containsKey(nums.get(i))) {
                return new int[] {map.get(nums.get(i)), i};
            } else {
                map.put(target-nums.get(i), i);
            }
        }
        return new int[] {};
    }
```
