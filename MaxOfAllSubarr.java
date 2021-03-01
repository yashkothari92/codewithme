package sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxOfAllSubarr {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 2, 4, 6, 4, 2, 1, 0 }; // 3,2,4,5,5,4,2
		int k = 3;

		System.out.println();
		List<Integer> olist = findMaxAllSubArrOptimized(arr, k);
		olist.forEach(a -> System.out.print(a + " "));
	}

	private static List<Integer> findMaxAllSubArrOptimized(int[] arr, int k) {
		List<Integer> result = new ArrayList<>();
		Deque<Integer> queue = new LinkedList<>();

		int i = 0;
		int j = 0;

		while (j < arr.length) {
			flushAdd(queue, arr, j);

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				result.add(queue.getFirst());

				if (queue.getFirst() == arr[i]) {
					queue.removeFirst();
				}
				i++;
				j++;
			}
		}
		return result;
	}

	private static void flushAdd(Deque<Integer> queue, int[] arr, int j) {
		while (!queue.isEmpty() && queue.getLast() < arr[j]) {
			queue.removeLast();
		}
		queue.add(arr[j]);
	}
}
