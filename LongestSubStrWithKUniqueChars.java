package sliding_window;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubStrWithKUniqueChars {

	public static void main(String[] args) {
		LongestSubStrWithKUniqueChars l = new LongestSubStrWithKUniqueChars();

		String str = "aabacbebebe";
		int k = 3;
		int len = l.findLongestSubstrWithKUniqueChars(str, k);

		System.out.println(len);
	}

	private int findLongestSubstrWithKUniqueChars(String str, int k) {
		int i = 0;
		int j = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new LinkedHashMap<>();

		while (j < str.length()) {
			// mapper
			if (!map.containsKey(str.charAt(j))) {
				map.put(str.charAt(j), 1);
			}else {
				map.put(str.charAt(j), 1 + map.get(str.charAt(j)));
			}

			// if #unique_chars < k
			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				maxLen = Math.max(maxLen, j - i + 1);
				j++;
			} else if (map.size() > k) {

				// keep incrementing i and updates map value until map's size > k
				while (map.size() > k) {
					int val = map.get(str.charAt(i));
					if (val == 1) {
						map.remove(str.charAt(i));
					} else {
						map.put(str.charAt(i), val--);
					}
					i++;
				}
				j++;
			}
		}

		return maxLen;
	}
}
