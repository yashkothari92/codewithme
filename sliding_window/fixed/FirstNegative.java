package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class FirstNegative {
	
	public static void main(String[] args) {
		int arr[] = {9, 1, -11, -4, -8, 5, 2};
		int k = 3;
		findFirstNegativesBF(arr, k);
		findFirstNegativeOptimized(arr, k);
	}

	private static void findFirstNegativeOptimized(int[] arr, int k) {
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<>();
		System.out.println();
		while (j < arr.length) {
			if (arr[j] < 0) {
				list.add(arr[j]);
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (!list.isEmpty())
					System.out.print(list.get(0) + " ");
				else
					System.out.print(" 0");

				if (!list.isEmpty() && arr[i] == list.get(0))
					list.remove(0);
				i++;
				j++;
			}

		}
	}

	private static void findFirstNegativesBF(int[] arr, int k) {
		boolean flag = false;
		for (int i = 0; i < arr.length - k + 1; i++) {
			for (int j = 0; j < k; j++) {
				if (arr[i + j] < 0) {
					System.out.print(arr[i + j] + " ");
					flag = true;
					break;
				}
			}

			if (!flag) {
				System.out.println("0 ");
			}
		}
	}
}
