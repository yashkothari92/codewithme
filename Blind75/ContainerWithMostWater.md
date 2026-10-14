LC 11, **Medium**
You are given an integer array heights where heights[i] represents the height of the i'th bar.

You may choose any two bars to form a container. Return the maximum amount of water a container can store.

```java
public int maxArea(int[] heights) {
    int left = 0;
    int right = heights.length-1;   
    int currentMax = 0;
    while(left < right) {
        // 1. Calculate width and boundary height
        int width = right-left;
        int currentHeight = Math.min(heights[left], heights[right]);

        // 2. Update max water if current container holds more
        currentMax = Math.max(currentMax, width*currentHeight);

        // 3. Move the pointer pointing to the shorter wall 
        if (heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
    }
  return currentMax;
}
```
