package sliding_window;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 1, 8, 2, 9, 1, 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int k = 2;

		// fetchMaxSumBruteForce(arr, k);
		fetchMaxSumOptimized(arr, k);
	}

	private static void fetchMaxSumOptimized(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int currSum = 0;
		int max = Integer.MIN_VALUE;

		while (j < arr.length) {
			currSum += arr[j];

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (currSum > max) {
					max = currSum;
				}
				currSum -= arr[i];

				i++;
				j++;
			}
		}
		System.out.println(max);
	}

	private static void fetchMaxSumBruteForce(int[] arr, int k) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length - k; i++) {
			int currMax = 0;
			for (int j = 0; j < k; j++) {
				currMax += arr[i + j];
			}
			if (currMax > max) {
				max = currMax;
			}
		}
		System.out.println(max);
	}

}
