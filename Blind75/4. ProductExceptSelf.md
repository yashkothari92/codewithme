LC 238, Difficulty: **Medium**

Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Follow-up: Could you solve it in O(n) time without using the division operation?

Example 1:

  Input: nums = [1,2,4,6]
  Output: [48,24,12,8]

Example 2:

  Input: nums = [-1,0,1,2,3]
  Output: [0,-6,0,0,0]

```java
public int[] productExceptSelf(int[] nums) {
    int pre = 1;
    int[] res = new int[nums.length];

    for(int i=0; i<nums.length; i++) {
        res[i] = pre; // Use [1, -1, 0, 0, 0]
        pre = pre*nums[i]; // Update [-1, 0, 0, 0, 0]
    }

    int right = 1;
    for(int i=nums.length-1; i>=0; i--) {
        res[i] = right*res[i]; // Use [0,-6,0,0,0]
        right = right*nums[i]; // Update [3->6->6->0]
    }
    return res;
}
```

