package sliding_window;

import java.util.LinkedHashMap;
import java.util.Map;

// Leetcode 3. Longest Substring Without Repeating Characters
public class LongestSubstrWithNoRepeatingChars {
	public static void main(String[] args) {
		LongestSubstrWithNoRepeatingChars l1 = new LongestSubstrWithNoRepeatingChars();
		String str = "";

		int len = l1.findLongestSubstrWithNoRepeatingChars(str);
		System.out.println(len);
	}

	private int findLongestSubstrWithNoRepeatingChars(String str) {
		int i = 0;
		int j = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new LinkedHashMap<>();

		while (j < str.length()) {

			// map generation
			if (!map.containsKey(str.charAt(j))) {
				map.put(str.charAt(j), 1);
			} else {
				map.put(str.charAt(j), 1 + map.get(str.charAt(j)));
			}
			
			// if uniqueChars & window size matches, get the Max Length
			if(map.size() == (j-i+1)) {
				maxLen = Math.max(maxLen, j-i+1);
			}
			
			// if unique chars size < window size => window has "extra" chars, remove junk
			if(map.size() < (j-i+1)) {
				while(map.size() < (j-i+1)) {
					if (map.containsKey(str.charAt(i))) {
						int val = map.get(str.charAt(i));
						if (val > 1) {
							map.put(str.charAt(i), val - 1);
						} else {
							map.remove(str.charAt(i));
						}
						i++;
					}
				}
			}
			j++;
		}
		return maxLen;
	}
}
