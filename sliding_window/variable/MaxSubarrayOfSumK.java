package sliding_window;

import java.util.HashMap;

// {1, 1, 5, 1, 1, 2, 5 };
// { 4, 1, 1, 1, 2, 3, 5 }; 
// { -5, 8, -14, 2, 4, 12 };
public class MaxSubarrayOfSumK {

	public static void main(String[] args) {
		MaxSubarrayOfSumK obj = new MaxSubarrayOfSumK();
		int arr[] = { 4, 1, 1, 1, 2, 3, 5 };
		int sum = 5;

		// int max = obj.findLongestSubArrOfSumPos(arr, sum);
		int max = obj.findLongestLengthofSubArrNeg(arr, sum);
		System.out.println(max);
	}

	private int findLongestSubArrOfSumPos(int[] arr, int sum) {
		int i = 0;
		int j = 0;
		int inSum = 0;
		int max = 0;

		while (j < arr.length) {

			inSum += arr[j];

			if (inSum < sum) {
				// j++;
			} else if (inSum == sum) {
				max = Math.max(j - i + 1, max);
				System.out.println("max=" + max);
				// j++;
			} else if (inSum > sum) {
				while (inSum > sum) {
					inSum -= arr[i];
					i++;

					if (inSum == sum) {
						max = Math.max(j - i + 1, max);
					}
				}
				// j++;
			}
			System.out.println("i:" + i + ",j:" + j + ":sum:" + inSum);
			j++;
		}
		return max;
	}

	private int findLongestLengthofSubArrNeg(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		int sum = 0;

		int i = 0;
		while (i < arr.length) {
			sum += arr[i];

			if (sum == k) {
				maxLen = i + 1; // prefix sum
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			if (map.containsKey(sum - k)) {
				// maxLen += 1;
				if (maxLen < (i - map.get(sum - k))) {
					maxLen = i - map.get(sum - k);
				}
			}
			i++;
		}
		return maxLen;
	}
}
