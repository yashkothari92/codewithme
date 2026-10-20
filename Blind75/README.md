# DSA Practice Log

Target: Senior roles at GCCs, product, mid-tier SaaS, fintech. Language: Java.
Plan: 8 weeks, pattern-based. Solved: 10 | Started: Oct 2026

## How to use this for a quick scan
1. Sort the table by **Confidence**, lowest first.
2. Read only the **Trick** column. If you can't rebuild the solution from it, open the file.
3. Redo anything rated 3 or below, cold, with a timer.

## Index

| # | Problem | Pattern | Trick (one line) | Time / Space | Diff | Time taken | Confidence (1-5) | Redo |
|---|---|---|---|---|---|---|---|---|
| 1 | Two Sum | Hash map | Store value to index; check the complement before inserting | O(n) / O(n) | Easy | | 5 | |
| 49 | Group Anagrams | Hashing | Key = sorted string or 26-count array | O(n*k) / O(n*k) | Med | | 4 | |
| 347 | Top K Frequent Elements | Hash map + buckets | Count, then bucket by frequency (index = count) | O(n) / O(n) | Med | | 4 | |
| 238 | Product of Array Except Self | Prefix / suffix | Left-product pass, then right-product pass; no division | O(n) / O(1) extra | Med | | 3 | |
| 128 | Longest Consecutive Sequence | Hash set | Only start counting where n-1 is absent | O(n) / O(n) | Med | | 3 | |
| 53 | Maximum Subarray | Kadane (DP) | cur = max(x, cur + x); track the best | O(n) / O(1) | Med | | 5 | |
| 15 | 3Sum | Sort + two pointers | Fix i, two pointers on the rest; skip duplicates | O(n^2) / O(1) | Med | | 4 | |
| 11 | Container With Most Water | Two pointers | Move the shorter wall; the shorter wall is the cap | O(n) / O(1) | Med | | 4 | |
| 3 | Longest Substring Without Repeating Characters | Sliding window | Expand right; on a duplicate, shrink left past it | O(n) / O(k) | Med | | 3 | |
| 42 | Trapping Rain Water | Two pointers | Move the side with the smaller max; water = max - height | O(n) / O(1) | Hard | | 3 | |

## By pattern

| Pattern | Problems |
|---|---|
| Hashing | 1, 49, 347, 128 |
| Prefix / suffix | 238, 42 (array version) |
| Two pointers | 15, 11, 42 |
| Sliding window | 3 |
| DP / Kadane | 53 |

## Common traps (from my own mistakes)
- Two pointers: loop on the pointers, not on derived values; re-decide the side on every iteration.
- Update the running max BEFORE computing water at that bar.
- Always guard null / empty / short input when the problem allows it.
- 3Sum: skip duplicates for i, left and right; test `[0,0,0,0]` and `[-2,0,0,2,2]`.
- Delete dead code and unused imports before committing.

## Per-file header template

```java
/**
 * LC <n> - <name> | <difficulty> | <pattern>
 *
 * RECOGNIZE:  <signals in the problem statement>
 * KEY IDEA:   <one line>
 * APPROACH:   <one or two lines>
 * COMPLEXITY: <time>, <space> (brute force: <time>)
 * TRAPS:      <mistakes to avoid>
 * WHY SAFE:   <the proof, in one sentence>
 * REVISIT:    <date>
 */
```

## Commit message format
`LC 42 trapping rain water: two pointers, O(1) space (28 min)`
