package sliding_window;

import java.util.HashMap;

public class LargestSubArrayZero {

	public static void main(String[] args) {
		LargestSubArrayZero obj = new LargestSubArrayZero();
		int[] arr = { 1, -1, 3, 2, -2, -8, 1, 7, 10, 23 };

		int len = obj.findLengthLongestSubArrayOfSumZero(arr);
		System.out.println(len);
	}

	private int findLengthLongestSubArrayOfSumZero(int[] arr) {
		int i = 0;
		int sum = 0;
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		// iterate until array's last element
		while (i < arr.length) {
			sum += arr[i];

			// when sum zero, updates max as prefix sum index
			if (sum == 0) {
				max = i + 1;
			}

			// if sum doesn't exist in a map, add it else fetch idx - value
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			} else {
				max = Math.max(max, i - map.get(sum));
			}

			i++;
		}

		return max;
	}
}
