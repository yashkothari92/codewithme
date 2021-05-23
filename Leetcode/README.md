# Leetcode

#1	Two Sums (E)

	Input: Given nums = [2, 7, 11, 15], target = 9,
	Output: return [0, 1]
	Explanation: Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	
	@map.put(target - nums[i], i)
	
#2	Add Two Numbers (M)

	[Traverse forward : Iterative
			  Reverse : Recursive]
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) : numbers stored in reverse order
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
	
	@First handle size & pad zeros at the end (because input reversed), then iteratively take node and add and carry over to next node
	At the end of traversing, see if remaining carry, prepend it to the resultant list1
	
#6	ZigZag Conversion  (M)

	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R

	And then read line by line: "PAHNAPLSIIGYIR"

	@	P   A   H   N			1		5		9		13
		A P L S I I G			2	4	6	8	10	12	14
		Y   I   R				3		7		11

	And then read line by line: "PAHNAPLSIIGYIR"
	---------
	n=3 -> 4
	---------
	 1	 2	 3	 4
	(P)	(A)	(Y)	(P)
	 5	 6	 7	 8
	(A)	(L)	(I) (S)
	 9	10	11	12
	(H)	(I) (R) (I)
	13	14 
	(N) (G) 

	--------
	n=4 -> 6
	--------						
	1	2	3	4	5	6			P			I			N				1			7			13
	P 	A	Y	P	A	L	.	.	A		L	S		I	g		==>		2		6	8		12	14
	7	8	9	10	11	12	  .		Y	A		H	R						3	5		9	11
	I	S	H	I	R	I			P			I							4			10
	13	14
	N	G

	--------
	n=5 -> 8
	---------
											P				H				1				9
	1	2	3	4	5	6	7	8			A			S	I				2			8	10
	P	A	Y	P	A	L	I	S	.	.	Y		I		R		==>		3		7		11
	9	10	11	12	13	14	15	16	  .		P	L			I	G			4	6			12	14
	H	I	R	I	N	G					A				N				5				13

	---------
	n=6 -> 10
	---------								
#17. Letter Combinations of a Phone Number (Medium)

	Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
	Return the answer in any order.
	A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	
	Example 1:
	Input: digits = "23"
	Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

	Example 2:
	Input: digits = ""
	Output: []

	Example 3:
	Input: digits = "2"
	Output: ["a","b","c"]
	
	@
	Since each digit can possibly mean one of several characters, we'll need to create code that branches down the different paths as we iterate through the input digit string (D).
	This quite obviously calls for a depth-first search (DFS) approach as we will check each permutation of characters and store them in our answer array (ans). For a DFS approach we can use one of several options, but a recursive solution is gerally the cleanest.
	But first, we'll need to set up a lookup table (L) to convert a digit to its possible characters. Since the digits are actually low-indexed integers, we can actually choose between an array or map/dictionary here with little difference.
	
#19. Remove Nth Node From End of List   (Medium)
	
	Given the head of a linked list, remove the nth node from the end of the list and return its head.

	Example 1:
	  Input: head = [1,2,3,4,5], n = 2
	  Output: [1,2,3,5]

	Example 2:
	  Input: head = [1], n = 1
	  Output: []

	Example 3:
	  Input: head = [1,2], n = 1
	  Output: [1]
	@ Two pass: 1) find the size of list  2) reach to size-n element and remove by adjusting next ptrs
	  One pass: 2 ptrs (slow & fast) advance fast ptr by n nodes, and increment both one by one, by the time fast reaches end, slow will be at removing node 

#20 	Valid Parentheses (E)

	Example 1:
		Input: "()"
		Output: true
	Example 2:
		Input: "()[]{}"
		Output: true
	Example 3:
		Input: "(]"
		Output: false
	Example 4:
		Input: "([)]"
		Output: false
	Example 5:
		Input: "{[]}"
		Output: true

	@Using stack (store opening brackets as key, and closing as val in Map)
	
#21 Merge Two Sorted Lists (E)

	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
	
	@merge() method of MergeSort 
	(until both the lists are non-empty, check if l1 <= l2 then l1++ else l2++; after one of the lists get exhausted, traverse the other list)
	
#32 Longest Valid Parentheses (Hard)
	
	Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
	Input: s = "(()"
	Output: 2
	Explanation: The longest valid parentheses substring is "()".
	
	@Stack: We will start by pushing -1 into the stack at first. This will denote index preceding to potential start of valid parentheses.
	A) s[i] == '(' - In this case, we will push the index into the stack (just as we do in valid parentheses check).
	B) s[i] == ')' - In this case, we will pop the index from the stack (again just as in parentheses check). Now, after popping
	
	*stack is not empty: pop the element, and update the MAX
	*stack is empty: when we have an extra ')' bracket push the index to stack again which will denote that bottom of stack will hold the index preceding to a potential valid parentheses.
	
#45. Jump Game II (Medium)
	
	Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Your goal is to reach the last index in the minimum number of jumps.
	You can assume that you can always reach the last index.

	Example 1:
	  Input: nums = [2,3,1,1,4]
	  Output: 2
	  Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

	Example 2:
	  Input: nums = [2,3,0,1,4]
	  Output: 2
	  
	@ Greedy approach
	Initially set the boundary as nums[0], and keep counting maxReachableIdx = Max(maxReachableIdx, i+nums[i])
	when you cross the boundary (i > boundary), reset the boundary to maxReachableIdx 
	and increment the jumpCounter

#48. Rotate Image (Medium)

	You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
	You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
	DO NOT allocate another 2D matrix and do the rotation.

	Example 1: (https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg)
	Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
	Output: [[7,4,1],[8,5,2],[9,6,3]]

	Example 2: (https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg)
	Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
	Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

	Example 3:
	Input: matrix = [[1]]
	Output: [[1]]

	Example 4:
	Input: matrix = [[1,2],[3,4]]
	Output: [[3,1],[4,2]]
	@ Rotate matrix by 90 degree
	  Step1: Transponse 
	  Step2: Swap (i, rows.size-i-1) row wise
	  
#51. N-Queens (Hard)

	The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
	Given an integer n, return all distinct solutions to the n-queens puzzle.
	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

	Example 1: (ref: https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)
	  Input: n = 4
	  Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
	  Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

	Example 2:
	  Input: n = 1
	  Output: [["Q"]]
	 
	@ Backtracking solution
	char board[] = new char[n][n]
	fill the board[] with '.' in the beginning
	place Queen at each row
	Before placing it in the next row, validate the position
		i) there should not be any queen at given column position on any of the rows
		ii) there should not be any queen at 45 degree diagonal (row-1, col+1)
		iii) there should not be any queen at 135 degree diagonal (row-1, col-1)
	after successful validation,
	add queue to the board
	recursively invoke fun ()
	add '.'
	
	at the end, build method will print row wise (Add to the List<String>).
	
	  
#54. Spiral Matrix  (Medium)

	Given an m x n matrix, return all elements of the matrix in spiral order.

	Example 1: (Ref: https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg)
	  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
	  Output: [1,2,3,6,9,8,7,4,5]

	Example 2: (Ref: https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg)
	  Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
	  Output: [1,2,3,4,8,12,11,10,9,5,6,7]
	
	@ top = 0, bottom = rows -1, left = 0, right = cols - 1
	one loop (top): 	traverse left to right: matrix[top][i]		top++;
	second loop (right):	traverse top to bottom: matrix[i][right]	right--;
	third loop (bottom):	traverse right to left: matrix[bottom][i]	bottom--;
	fourth loop (left):	traverse bottom to top: matrix[i][left] 	left++;
	
	
	
#62	Unique Paths	(Medium)
	
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	How many possible unique paths are there?
	
	Example 1:
		Input: m = 3, n = 7
		Output: 28

	Example 2:
		Input: m = 3, n = 2
		Output: 3
		Explanation:
		From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
		1. Right -> Down -> Down
		2. Down -> Down -> Right
		3. Down -> Right -> Down

	Example 3:
		Input: m = 7, n = 3
		Output: 28

	Example 4:
		Input: m = 3, n = 3
		Output: 6
		
	@[m * n] grid, As you move to down [m * n-1] or right [m-1 * n] We can visualize a tree and [1, n] or [m, 1] can be our base case.
	Brute force runs into TLE
	We can store once-calculated cells, and return directly when same cell recurs in different branch of the tree (i.e. Memoized)
	https://www.youtube.com/watch?v=oBt53YbR9Kk (Refer gridTraveler problem for better understanding/ explanation)
	
#63 	UniquePaths II	(Medium)

	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	An obstacle and space is marked as 1 and 0 respectively in the grid.

	Example 1:
	  Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
	  Output: 2
	  Explanation: There is one obstacle in the middle of the 3x3 grid above.
	  There are two ways to reach the bottom-right corner:
	  1. Right -> Right -> Down -> Down
	  2. Down -> Down -> Right -> Right

	Example 2:
	  Input: obstacleGrid = [[0,1],[0,0]]
	  Output: 1
	  
	@ Brute force results into TLE (as 2^(row*col))
	Starts with [0][0], and call recursive function. 
	Consider boundary condition & obstacle, return 0; when [row][col] hits the end cell return 1;
	For Memoization, use 2D array (initialize with -1, when >-1 returns the [row][col] value)
 
#65. Valid Number (Hard)

	A valid number can be split up into these components (in order):
	    A decimal number or an integer.
	    (Optional) An 'e' or 'E', followed by an integer.

	A decimal number can be split up into these components (in order):
	    (Optional) A sign character (either '+' or '-').
	    One of the following formats:
		At least one digit, followed by a dot '.'.
		At least one digit, followed by a dot '.', followed by at least one digit.
		A dot '.', followed by at least one digit.

	An integer can be split up into these components (in order):
	    (Optional) A sign character (either '+' or '-').
	    At least one digit.

	For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], 
	while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

	Given a string s, return true if s is a valid number.

	Example 1:
	    Input: s = "0"
	    Output: true

	Example 2:
	    Input: s = "e"
	    Output: false

	Example 3:
	    Input: s = "."
	    Output: false

	Example 4:
	    Input: s = ".1"
	    Output: true
	    
	@ Explanation:
	A number is valid number if is of below format
		General Format: [Sign]XXXX . YYYY [e][Sign]ZZZZ
				  |	|     |	   |   |     |
				 +/- [0-9]  [0-9] e/E  +/-  [0-9]

	Negative testcases:
		"." decimal point after decimal seen in past
		"." decimal point in power value
		"e" e again after an exponent power seen in the past
		"e" without prefixed no
		"+/-" occurrs at any point other than 0th index or at indexOfE+1
		See any other value than [0-9], +/-, e/E
     
    
#70	Climbing Stairs	(Easy)

	You are climbing a staircase. It takes n steps to reach the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

	Example 1:
	  Input: n = 2
	  Output: 2
	  Explanation: There are two ways to climb to the top.
	  1. 1
	  step + 1 step
	  2. 2 steps

	Example 2:
	  Input: n = 3
	  Output: 3
	  Explanation: There are three ways to climb to the top.
	  1. 1 step + 1 step + 1 step
	  2. 1 step + 2 steps
	  3. 2 steps + 1 step
	@ Brute force recursive soln runs into TLE canClimb(n-1) + canClimb(n-2) as can climber 1 or 2 steps 
	Memoized version of it runs in 0ms

#79	Word Search  (Medium)

	Given an m x n grid of characters board and a string word, return true if word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.

	Example 1:

	  "A","B","C","E",
	  "S","F","C","S",
	  "A","D","E","E"

	  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	  Output: true

	Example 2:

	  "A","B","C","E",
	  "S","F","C","S",
	  "A","D","E","E"

	  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
	  Output: true

	Example 3:

	  "A","B","C","E",
	  "S","F","C","S",
	  "A","D","E","E"

	  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
	  Output: false
	@ Process: 
	 1. Iterate through 2D board array
	 2. when we find if any 2D element matches with 1st char of word we are looking for i.e. if(word.charAt(0) == board[i][j])
	 3. Recursively call search method (i, j, board, 0, word)
	 4. search method
	 	4.1. checks if (idx == word.count) return true
	 	4.2  checks boundary condition (array out of bounds || word.charAt(i) != board[i][j] || visited[i][j]) return false
	 	4.3  recursive call to adjcent neibours (i + 1, j, board, idx + 1, word) || (i - 1, j, board, idx + 1, word) || 
	 						(i, j + 1, board, idx + 1, word) || (i, j - 1, board, idx + 1, word) return true
	 	4.4  At the end, return false
	
#83	Remove Duplicates from Sorted List (E)

	Example 1:
		Input: 1->1->2
		Output: 1->2
	Example 2:
		Input: 1->1->2->3->3
		Output: 1->2->3
		
	@O(n^2) solution (outer_loop: current(head), inner_loop: nextPtr.next)
	Need to find O(n) solution [TBD]
	
#86. Partition List   (Medium)

	Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	You should preserve the original relative order of the nodes in each of the two partitions.

	Example 1:
		Input: head = [1,4,3,2,5,2], x = 3
		Output: [1,2,2,4,3,5]

	Example 2:
		Input: head = [2,1], x = 2
		Output: [1,2]
	@Use two linkedlists (smaller list contains elements of original linkedlist  where element < x)
				(greater list contains elements of original linkedlist where element >= x)
		at the end of iteration, 
			connect smaller.next to greaterdummy.next
			greater.next to null
			return smallerdummy.next
	
#94	Binary Tree Inorder Traversal  (M)

	Given a binary tree, return the inorder traversal of its nodes' values.

	Example:
	Input: [1,null,2,3]
	   	1
		\
		 2
		/
	   	3

	Output: [1,3,2]
	
	@(call sub routine for root
	sub routine: push root, and all its left children to stack;
	pop an element & add it to the list, check if right child exists, call subroutine)

#98	Validate Binary Search Tree (M)

	Given a binary tree, determine if it is a valid binary search tree (BST).
	Example 1:

	    2
	   / \
	  1   3

	Input: [2,1,3]
	Output: true
	Example 2:

	    5
	   / \
	  1   4
	      / \
	      3   6

	Input: [5,1,4,null,null,3,6]
	Output: false
	Explanation: The root node's value is 5 but its right child's value is 4.
	
	@one approach: perform inorder traversal, and check if next element is smaller than current one
	2nd approach: recursively validatBST(root, left, right) ; isValidBSTUtil(root.left, left, root) && isValidBSTUtil(root.right, root, right);
	
#100 Same Tree (Easy)

	Given two binary trees, write a function to check if they are the same or not.	
	Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
	Example 1:
		Input:     	   1         1
				  / \       / \
				 2   3     2   3

				[1,2,3],   [1,2,3]

		Output: true
		
	Example 2:
		Input:     	   1         1
				  /           \
				 2             2

				[1,2],     [1,null,2]

		Output: false
		
	Example 3:
		Input:     
				  1         1
				  / \       / \
				 2   1     1   2

				[1,2,1],   [1,1,2]

		Output: false
		
	@Recursion: return (p.val == q.val) &&  isSameTree(p.left, q.left) &&   isSameTree(p.right, q.right);
	
#101. Symmetric Tree  (Easy)

	Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

	Example 1:
	Input: root = [1,2,2,3,4,4,3]
	Output: true

	Example 2:
	Input: root = [1,2,2,null,3,null,3]
	Output: false
	
	@Recursion: return leftTree.val == rightTree.val && isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);

	
#102	Binary Tree Level Order Traversal (M)

		Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

		For example:
		Given binary tree [3,9,20,null,null,15,7],
			3
		   	/ \
		  	9  20
			   /  \
		   	  15   7
		return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
		
		@use Queue and while(nodeCount > 0) keep adding left & right to queue
		
#103	Binary Tree Zigzag Level Order Traversal (M)

		Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
		
		For example:
		Given binary tree [3,9,20,null,null,15,7],
			3
		   	/ \
		  	9  20
			   /  \
		   	   15   7
		return its zigzag level order traversal as:
		[
		  [3], 		--level1
		  [20,9],	--level2
		  [15,7]	--level3
		]
		
		@Use Stack
		push root (level 0) to stack
		pop all the elements from stack, store it into List
		iterate it over the List, if even level: push right and left; else push left & right
		
#104	Maximum Depth of Binary Tree (E)

		Given a binary tree, find its maximum depth.
		The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
		
		Given binary tree [3,9,20,null,null,15,7],

		    3
		   / \
		  9  20
		     /  \
		    15   7
		return its depth = 3.
		
		@1 + Math.max(recurse(left), recurse(right))
		
#107	Construct Binary Tree from Preorder and Inorder Traversal (M)

		@check pre-order element - where it exists in inorder[], 
		and then pass it to the recursive funtion 
		node.left = (pre, in, inStart, idx-1),
		node.right = (pre, in, idx+1, inEnd)
		
#108	Convert Sorted Array to Binary Search Tree (Easy)

	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	Given the sorted array: [-10,-3,0,5,9],

	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

	      0
	     / \
	   -3   9
	   /   /
	 -10  5
	 
	 @recursion, (Binary Search algo):  middle = (start + (end - start)/2);
	 	root (array[middle]); 
		root.left(start, middle-1); 
		root.right(middle+1, end)
	 
#109	Convert Sorted List to Binary Search Tree (Medium)
	
	Same question as above, only change is input (here its LinkedList as opposed to an array)
	
	Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

	Example 1:
		Input: head = [-10,-3,0,5,9]
		Output: [0,-3,9,-10,null,5]
		Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

	Example 2:
		Input: head = []
		Output: []

	Example 3:
		Input: head = [0]
		Output: [0]

	Example 4:
		Input: head = [1,3]
		Output: [3,1]
		
	@find middle node using two (slow & fast) pointers, 
	and assign slow ptr (mid node) to root
	root.left(head, slow)
	root.right(slow.next, tail)

#111	Minimum Depth of Binary Tree (E)

		Given a binary tree, find its minimum depth.
		The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.	
		
		Given binary tree [3,9,20,null,null,15,7],

			3
		   	/ \
		  	9  20
			   /  \
		       	  15   7
		return its minimum depth = 2.
		
		@ height == 1 ? 1+Math.max(recurse(left), recurse(right)):1 + Math.min(recurse(left), recurse(right))
		
#112 Path Sum	(Easy)

	Given the root of a binary tree and an integer targetSum, 
	return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

	A leaf is a node with no children.

	Example 1:
		Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
		Output: true

	Example 2:
		Input: root = [1,2,3], targetSum = 5
		Output: false

	Example 3:
		Input: root = [1,2], targetSum = 0
		Output: false
		
	@ Recursive solution: 
		return when there's leaf node (i.e. root.left & root.right == null && targetSum-root.val == 0)
		pass 2 args (root.left, targetSum - root.val)	
		
#114. Flatten Binary Tree to Linked List  (Medium)

	Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

	Example 1:
	  Input: root = [1,2,5,3,4,null,6]
	  Output: [1,null,2,null,3,null,4,null,5,null,6]

	Example 2:
	  Input: root = []
	  Output: []

	Example 3:
	  Input: root = [0]
	  Output: [0]
	@ here child ptr points to the next node in the Linkedlist
	[As "linked list" should be in same order as pre-order traversal, store into the stack in "reverse" pre-order: right, left, value]
	Used stack to push root initially, and its right & left (hence left child will be on the top of the Stack)
	Assign current.right = stack.peek(), current.left = null

		
#141	Linked List Cycle (E)

		Given a linked list, determine if it has a cycle in it.
		
		@use 2 ptrs, slow increments by 1; fast increments by 2
		
#142	Linked List Cycle II (M)

		Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
		
		@use 2 ptrs, slow by 1; fast by 2 
		(once cycle detected, move slow ptr to head, and keep fast at same place where cycle detected)
		(move both by 1, as long as they hit the same node (i.e. cycle begins))
		
#144	Preorder Traversal (M)
	
	Given a binary tree, return the preorder traversal of its nodes' values.

	Example:

	Input: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3

	Output: [1,2,3]
	
	@ pass root to subroutine(root), and add root & its left children to the stack & list.
	when left is null, iterate over (!stack.isEmpty) => pop the element, and get its right child and
	call subroutine for the right child.
	
#155	Min Stack (E)

		Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
		push(x) -- Push element x onto stack.
		pop() -- Removes the element on top of the stack.
		top() -- Get the top element.
		getMin() -- Retrieve the minimum element in the stack.
		
		@use 1 stack for push, pop, top; use 2nd stack exclusive for minimum element
		
#160	Intersection of Two Linked Lists (E)

		Write a program to find the node at which the intersection of two singly linked lists begins.

		For example, the following two linked lists:
			 a1 -> a2 \
				   c1 -> c2 -> c3
				 /
		  b1 -> b2 -> b3	
		begin to intersect at node c1.
		
		@align the size, and get both lists at same level 
		and then increment both by 1 until same node found
		
#179	Largest Number (M)

		Given a list of non negative integers, arrange them such that they form the largest number.

		Example 1:
			Input: [10,2]
			Output: "210"
		
		Example 2:
			Input: [3,30,34,5,9]
			Output: "9534330"
		Note: The result may be very large, so you need to return a string instead of an integer.
		@sort adjacent elements 
		3,30 => Math.max(330, 303)
		330,34 => Math.max(33034,34330)
		34330,5 => Math.max(343305, 534330)
		534330,9 => Math.max(5343309, 9534330) => 9534330
		
#199	Binary Tree Right Side View (Medium)

	Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

	Example 1:
	  Input: root = [1,2,3,null,5,null,4]
	  Output: [1,3,4]

	Example 2:
	  Input: root = [1,null,3]
	  Output: [1,3]

	Example 3:
	  Input: root = []
	  Output: []
	  
	@ BFS (using Queue)
	add root first, and then until queue is not empty, add both the children (left & right)
	when size == i, store value to list	

#204. Count Primes (Easy)

	Count the number of prime numbers less than a non-negative number, n.

	Example 1:
		Input: n = 10
		Output: 4
		Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

	Example 2:
		Input: n = 0
		Output: 0

	Example 3:
		Input: n = 1
		Output: 0
		
	@ Multiple ways:
	(I) iterate till sqrt(num)
	(II) Sieve of Eratosthenes
		
#206	Reverse Linked List (E)

		Example:
			Input: 1->2->3->4->5->NULL
			Output: 5->4->3->2->1->NULL
			
			@current, next, prev
			
#216. Combination Sum III (Medium)

	Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

	    Only numbers 1 through 9 are used.
	    Each number is used at most once.

	Return a list of all possible valid combinations. 
	The list must not contain the same combination twice, and the combinations may be returned in any order.

	Example 1:
	  Input: k = 3, n = 7
	  Output: [[1,2,4]]
	  Explanation:
	  1 + 2 + 4 = 7
	  There are no other valid combinations.

	Example 2:
	  Input: k = 3, n = 9
	  Output: [[1,2,6],[1,3,5],[2,3,4]]
	  Explanation:
	  1 + 2 + 6 = 9
	  1 + 3 + 5 = 9
	  2 + 3 + 4 = 9
	  There are no other valid combinations.

	Example 3:
	  Input: k = 4, n = 1
	  Output: []
	  Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.

	Example 4:
	  Input: k = 3, n = 2
	  Output: []
	  Explanation: There are no valid combinations.

	Example 5:
	  Input: k = 9, n = 45
	  Output: [[1,2,3,4,5,6,7,8,9]]
	  Explanation:
	  1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
	  There are no other valid combinations.
	
	@ Backtracking
	iterate over loop (1 ...9)
		
		add element (i) to the current-set
		invoke recursiveFun pass ans, deduct 1 from numOfElems, and deduct sum-i, currSet
		remove element (i) from the current-set
	
	(will be base case)
	when numOfElems == 0 and sum == 0 (this means we meets the target with numOfelems=k)
	add the currSet to the ans.
			
#225	Implement Stack using Queues (E)

		@take 2 queues
		dump all elements of Q1 to Q2 until Q1.size == 1
		pop last element of Q1 -> store and return 
		and swap Q1 & Q2
		
#226. Invert Binary Tree  (Easy)

	Given the root of a binary tree, invert the tree, and return its root.

	Example 1:
	Input: root = [4,2,7,1,3,6,9]
	Output: [4,7,2,9,6,3,1]

	Example 2:
	Input: root = [2,1,3]
	Output: [2,3,1]

	Example 3:
	Input: root = []
	Output: []

	@ Recursive approach
		left = invertTree(root.left);
		right = invertTree(root.right);

		root.left = right;
		root.right = left;
	Iterative version (can be done using BFS/Queue)	
		
#232	Implement Queue using Stacks  (E)

		@take 2 stacks
		push -> to S1
		pop -> s2.peek (If s2 empty => transfer s1 to s2)
		
#234	Palindrome Linked List  (E)

		Example 1:
			Input: 1->2
			Output: false
		Example 2:
			Input: 1->2->2->1
			Output: true
		@Reverse2nd half and match both the halves
		
#237 	Delete Node in a Linked List (E) - without head

	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	Given linked list -- head = [4,5,1,9], which looks like following:
	
	Example 1:
		Input: head = [4,5,1,9], node = 5
		Output: [4,1,9]
		Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
	Example 2:
		Input: head = [4,5,1,9], node = 1
		Output: [4,5,9]
		Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
		
	@clone next node (data + next address) and store it to the input node (which is to be deleted)
	
#239	Sliding Window Maximum  (Hard

	You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
	You can only see the k numbers in the window.
	
	Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
	Output: [3,3,5,5,6,7]
	
	@ use j-i+1 < k strategy (Use Deque data-structure, keep Max element to the front of queue - 
	if element is larger than the Rear element, keep removing it until largest element is set to the front of Deque)
		
#268	Missing Number	(E)

		Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

		Example 1:
			Input: [3,0,1]
			Output: 2
		Example 2:
			Input: [9,6,4,2,3,5,7,0,1]
			Output: 8
		Note:
		Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
		
		@
		1. sort and find missing by taking diff from adjacent element
		2. Gauss n*(n+1)/2 - sum = missing number
		3. Bit manipulation - XOR
		
#283	 Move Zeroes (E)

	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	Example:

	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]
	
	@while iterating over an input, find non-zero elements and put it into initial places (4 non-zero)
	later fill remaining places with zeros (length - filled = remaining (2))
	
#304. Range Sum Query 2D - Immutable  (Medium)

	Given a 2D matrix matrix, handle multiple queries of the following type:
	    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

	Implement the NumMatrix class:

    	NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
   	 int sumRegion(int row1, int col1, int row2, int col2) 
	 Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

	Example 1: (Ref: https://assets.leetcode.com/uploads/2021/03/14/sum-grid.jpg)
	  Input
	  ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
	  [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
	  Output
	  [null, 8, 11, 12]

	  Explanation
	  NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
	  numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
	  numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
	  numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
	  
	@ Brute-force approach (expensive)
		iterate over both parent loop rows
		inner loop cols, and accumulate sum
	DP : [TBD]
	
#329. Longest Increasing Path in a Matrix  (Hard)

	Given an m x n integers matrix, return the length of the longest increasing path in matrix.
	From each cell, you can either move in four directions: left, right, up, or down. 
	You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

	Example 1:
		Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
		Output: 4
		Explanation: The longest increasing path is [1, 2, 6, 9].

	Example 2:
		Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
		Output: 4
		Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

	Example 3:
		Input: matrix = [[1]]
		Output: 1
		
	@DFS recursive soln along with memoization
	
#341. Flatten Nested List Iterator  (Medium)

	You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. 
	Implement an iterator to flatten it.

	Implement the NestedIterator class:
	    NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
	    int next() Returns the next integer in the nested list.
	    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

	Example 1:
	Input: nestedList = [[1,1],2,[1,1]]
	Output: [1,1,2,1,1]
	Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

	Example 2:
	Input: nestedList = [1,[4,[6]]]
	Output: [1,4,6]
	Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
	
	@ It is easiest to apply our flattening method (flatten()) during the class construction process, 
	so that we only ever store the flattened list (data) in our class instance. Since there can be multiple layers of nesting, we should make flatten a recursive function.
	With flatten, we should iterate through the given list and if the current element (el) is an integer we should push its contained value onto queue, otherwise we should recursively call flatten on the nested list contained in el.
	Once our queue is successfully flattened, next() should be as easy as removing and returning the lead element of data. When queue becomes empty, then hasNext() can return false.
	
LC#377. Combination Sum IV (Medium)

	Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
	The answer is guaranteed to fit in a 32-bit integer.

	Example 1:
	    Input: nums = [1,2,3], target = 4
	    Output: 7
	    Explanation:
	    The possible combination ways are:
	    (1, 1, 1, 1)
	    (1, 1, 2)
	    (1, 2, 1)
	    (1, 3)
	    (2, 1, 1)
	    (2, 2)
	    (3, 1)
	    Note that different sequences are counted as different combinations.

	Example 2:
	    Input: nums = [9], target = 3
	    Output: 0
	@ Brute force results into TLE (At each index, if the element is less than target, then we can always form a combination by picking the current element)
	  Same implementation can be converted into DP (Top-down approach) by simple tweaks (int[] memo)
	  
#429. N-ary Tree Level Order Traversal  (Medium)

	Given an n-ary tree, return the level order traversal of its nodes' values.
	Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

	Example 1:  (https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)
	  Input: root = [1,null,3,2,4,null,5,6]
	  Output: [[1],[3,2,4],[5,6]]

	Example 2: (https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png)
	  Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	  Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
	
	@ same as Binary Tree level order Traversal
	But instead of adding left & right child into the queue, add all children to the queue.
	
#443. String Compression (Medium)
	
	Given an array of characters chars, compress it using the following algorithm:

	Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.

	The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

	After you are done modifying the input array, return the new length of the array.

	Follow up:
	Could you solve it using only O(1) extra space?

	Example 1:
		Input: chars = ["a","a","b","b","c","c","c"]
		Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
		Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

	Example 2:
		Input: chars = ["a"]
		Output: Return 1, and the first character of the input array should be: ["a"]
		Explanation: The only group is "a", which remains uncompressed since it's a single character.

	Example 3:
		Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
		Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
		Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

	Example 4:
		Input: chars = ["a","a","a","b","b","a","a"]
		Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
		Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.
	@start with i=0; iterate until i < chars.length
	 take j = i; while (j < chars.length && chars[j] == chars[i] j++
	 occurrences = (j-1) > 1; consider adding it; else leave with just alphabet
	 
#462. Minimum Moves to Equal Array Elements II  (Medium)

	Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
	In one move, you can increment or decrement an element of the array by 1.

	Example 1:
	  Input: nums = [1,2,3]
	  Output: 2
	  Explanation:
	  Only two moves are needed (remember each move increments or decrements one element):
	  [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

	Example 2:
	  Input: nums = [1,10,2,9]
	  Output: 16
	
	@
    	// 1  0  0  8  6  <original input>
    	// 0  0  1  6  8  sort & pick <mid> : 1
    	// 1  1  0  5  7 = <14 steps> to make every element as <mid>
	    
#509. Fibonacci Number    (Easy)

	The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
	such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
	F(0) = 0, F(1) = 1
	F(n) = F(n - 1) + F(n - 2), for n > 1.

	Given n, calculate F(n).
	Input: n = 2
	Output: 1

	Input: n = 3
	Output: 2

	Input: n = 4
	Output: 3

	@ standard recursive brute-force solution
	standard memoized solution
	iterative approach (with rolling previous pointers technique)
	
#572. Subtree of Another Tree	(Easy)
	
	Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

	A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

	Example 1: https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg
	Input: root = [3,4,5,1,2], subRoot = [4,1,2]
	Output: true

	Example 2: https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg
	Input: root = [3,4,5,1,2,null,null,0], subRoot = [4,1,2]
	Output: false
	
	@
	recursive solution partially same as SameTree problem as it boils down to checking if both the given subtree & another tree is same
	1: isSameTree(root, subRoot) -> returns true if both the tress are same
	2: isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot) evenually calls isSameTree to check if subRoot matches with left or right subtree.

	
#583. Delete Operation for Two Strings  (Medium)

	Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
	In one step, you can delete exactly one character in either string.

	Example 1:
		Input: word1 = "sea", word2 = "eat"
		Output: 2
		Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

	Example 2:
		Input: word1 = "leetcode", word2 = "etco"
		Output: 4
	
	@ Using LCS (Longest common subsequence, we find common chars from both the strings, rest of the chars can be deleted to make both the strings same.
		return word1.length() + word2.length() - 2*lcs (word1, word2, word1.length(), word2.length(), memo);
	
#589. N-ary Tree Preorder Traversal   (Easy)

	Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
	Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

	Example 1:
	  Input: root = [1,null,3,2,4,null,5,6]
	  Output: [1,3,5,6,2,4]

	Example 2:
	  Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	  Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
	 @
	 Recursive soln -> pretty Easy 
	 (The solution to this question is very similar to 144. Binary Tree Preorder Traversal. 
	 The only difference here is that we have an array of child nodes (children) instead of left & right pointers for each node.)
	 	 
    	 If the node/root is null, return ans. (Base Condition)
    	 Push that node into our ans array (since this is preorder traversal) and recurse for each node in the children array. (Recursive Part)
	 
#609. Find Duplicate File in System (Medium)

	Given a list paths of directory info, including the directory path, and all the files with contents in this directory,
	return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.

	A group of duplicate files consists of at least two files that have the same content.

	A single directory info string in the input list has the following format:
	    "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

	It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". 
	Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

	The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. 
	A file path is a string that has the following format:
	    "directory_path/file_name.txt"

	Example 1:
	  Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
	  Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

	Example 2:
	  Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
	  Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
	  
	@
	Consider the directory - "root/a 1.txt(abcd) 2.txt(efgh)". We have -
   	Main Directory: root/a. All the characters that occur before the first space will constitute the main directory
		str.split("\\s"); => str[0]
    	File Name: 1.txt. All the characters after space till the first opening bracket (() will constitite the file name inside the main directory.
		str.substring(0, str.indexOf('('));
    	content: abcd. All the characters after the first opening bracket till closing bracket will constitute the file content of current file name.
		str.substring(str.indexOf(')')+1);
		
	String filePath = str[0]+"/"+fileName
	map.put(content, new ArrayList().add(filePath) | get(content).add(filePath));	// Map<String, List<String>>
	
	At the end, return the result when map.getValue().size() > 1
	List<List<String>> res = map.entrySet().stream().filter(mp -> mp.getValue().size() > 1).map(mp -> mp.getValue()).collect(Collectors.toList());

#622	Design Circular Queue (Medium)
	
	Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO  principle and 
	the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
	
	@Used LinkedList (both head & tail) data-structure to implement Circular Queue operations.
	
#630	Course Schedule III	(Hard) : May 2
	
	There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that 
	the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

	You will start on the 1st day and you cannot take two or more courses simultaneously.

	Return the maximum number of courses that you can take.

	Example 1:
	 Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
	 Output: 3
	 Explanation: 
		There are totally 4 courses, but you can take 3 courses at most:
		First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
		Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
		Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
		The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

	Example 2:
	  Input: courses = [[1,2]]
	  Output: 1

	Example 3:
	  Input: courses = [[3,2],[4,3]]
	  Output: 0
	
	@Sort course deadlines first
	Maintain max-heap (with Priority Queue)
	When course duration < deadline, add it to the queue; if course duration < queue.peek() -> swap current course with queue.peek()
	
#665. Non-decreasing Array  (Medium)

	Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
	We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

	Example 1:
	  Input: nums = [4,2,3]
	  Output: true
	  Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

	Example 2:
	  Input: nums = [4,2,1]
	  Output: false
	  Explanation: You can't get a non-decreasing array by modify at most one element.

	@ ----------------------------------
	(Ref: [https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC++-Simple-greedy-like-solution-with-explanation/109180])
	
	The problem requires that every number has to be equal or greater than previous number.
	If we encounter a failing condition where the number is not greater or equal to previous (smaller than previous) we need to make a correction. Correction can be made in either of two ways:

	    Make the previous number smaller or equal to current number
	    Make the current number equal to previous number

	We can do (1) as long as the number at position i-2 is equal or lower than the current element. (if i-2 is valid)
	In case 1 below we can do this at (3) (i = 2) as the element 1 (i = 0) fulfills 1 <= 3. We can replace 7 with 3.
	However, this cannot be done in case 2 as 4 <= 3 does not satisfy.

	Correction with technique (1) takes priority as there is no risk in lowering the value but there is a risk associated if the value is increased. (Consider scenario in case 1 if we replace 3 with 7, it will fail to satisfy the condition for the last element)

	We have to make correction with (2) if we cannot achieve it by (1). In which case we increase the value of current element by matching previous element. In case 2, we replace 3 with 7.

	Also we only compare condition with the previous element only because as we move forward we know the previous numbers are already validated .

	Case 1:
	     7
	     /\    4
	    /  \  /
	   /    \/
	  /      3
	 1

	Case 2:

		       9
		      /
	  7          /
	  /\        /
	 /  \      /
	/    \    /
	4      \  /
	       \/
	       3(i)

	-------------------------------------

#667	Beautiful Arrangement II  (Medium)

	Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
	Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
	If there are multiple answers, print any of them.
	
	Example 1:
		Input: n = 3, k = 1
		Output: [1, 2, 3]
		Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.

	Example 2:
		Input: n = 3, k = 2
		Output: [1, 3, 2]
		Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
		
	@Observe the pattern by thinking multiple testcases
	------------------------- ------------------------- ------------------------- ------------------------- 
	N=7     (k+1) permutations, get the low & high and follow:  // res[] = {low, high, low+1, high-1, low+2, high-2, ...} + rest of the elements
	-
	k=1    (1..2)       [1, 2, 3, 4, 5, 6, 7]     Unique Adjacent Difference: 1
	k=2    (1..3)       [1, 3, 2, 4, 5, 6, 7]     Unique Adjacent Difference: 2, 1
	k=3    (1..4)      [1, 4, 2, 3, 5, 6, 7]      Unique Adjacent Difference: 3, 2, 1
	k=4    (1..5)      [1, 5, 2, 4, 3, 6, 7]      Unique Adjacent Difference: 4, 3, 2, 1
	k=5    (1..6)       [1, 6, 2, 5, 3, 4, 7]     Unique Adjacent Difference: 5, 4, 3, 2, 1
	k=6    (1..7)       [1, 7, 2, 6, 3, 5, 7]     Unique Adjacent Difference: 6, 5, 4, 3, 2, 1
	------------------------- ------------------------- ------------------------- ------------------------

#696 Count Binary Substrings (Easy)
 
	Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, 
	and all the 0's and all the 1's in these substrings are grouped consecutively.

	Substrings that occur multiple times are counted the number of times they occur.

	Example 1:
		Input: "00110011"
		Output: 6
		Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

		Notice that some of these substrings repeat and are counted the number of times they occur.
		Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

	Example 2:
		Input: "10101"
		Output: 4
		Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
	@ Two Groups (curr, prev) 
	res += Math.min(curr, prev)
	00111 -> min(grp('0'), grp('1')) => 1
	
#745.	Prefix and Suffix Search	(Hard): May Day1
	
	Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.
	Implement the WordFilter class:

        WordFilter(string[] words) Initializes the object with the words in the dictionary.
        f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix and the suffix suffix. 
        If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.

	Example 1:
	Input
		["WordFilter", "f"]
		[[["apple"]], ["a", "e"]]
	Output
		[null, 0]

	Explanation
	WordFilter wordFilter = new WordFilter(["apple"]);
	wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
	
	@ Create 2 TrieNodes (one for prefix to store chars in forward direction; another for suffix to store chars in backward direction)
	startWith method returns List<Integer> indexes
	compare 2 obtained lists (pList, sList) and return the largest index (if more than one valid index), else return -1 (if no valid index found)

#755	Global and Local Inversions (Medium)

	We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
	The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
	The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
	Return true if and only if the number of global inversions is equal to the number of local inversions.
	
	Ex1) Input: A = [1,0,2]
	Output: true
	Explanation: There is 1 global inversion, and 1 local inversion.
	
	Ex2) Input: A = [1,2,0]
	Output: false
	Explanation: There are 2 global inversions, and 1 local inversion.

	@Brute force results into TLE
	Idea: We can observe that each local inversion is global inversion (or local inversions are subset of global inversions). 
	For both of them to be equal, every global inversion must only be a local inversion.
	A global inversion can be limited to be only a local inversion if for every 0 <= i < N, abs(A[i] - i) <= 1.

	Why?
	Because, if A[i] - i > 1, we can have atleast 2 pairs (i,j) and (i,k) such that A[i] > A[j] and A[i] > A[k] but if every global inversion 
	has to be only local inversion, we should only have gotten a single pair (i,j) (more specifically (i,i+1)) such that A[i] > A[j].
	Eg. [2,0,1], here A[0]-0 = 2 > 1, so we got two pairs of index (0,1) and (0,2) making global inversions != local inversions
	
#816. Ambiguous Coordinates (Medium)

	We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". 
	Then, we removed all commas, decimal points, and spaces, and ended up with the string s.  
	Return a list of strings representing all possibilities for what our original coordinates could have been.

	Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", 
	or any other number that can be represented with less digits. 
	Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

	The final answer list can be returned in any order. 
	Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

	Example 1:
	  Input: s = "(123)"
	  Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]

	Example 2:
	  Input: s = "(00011)"
	  Output:  ["(0.001, 1)", "(0, 0.011)"]
	  Explanation: 
	  0.0, 00, 0001 or 00.01 are not allowed.

	Example 3:
	  Input: s = "(0123)"
	  Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]

	Example 4:
	  Input: s = "(100)"
	  Output: [(10, 0)]
	  Explanation: 
	  1.0 is not allowed.

	@ step1: remove brackets first by	 	s.substring(1, s.length()-1);
	  step2: break string into 2 parts	 	for (i=1; i<len; i++) s.substring(0, i) & s.substring(i, len);
	  step3: add dot in each of the 2 parts	 	for (i=1; i<len; i++) s.substring(0, i)+"."+s.substring(i, len); add all dot sub-strings to List
	  step4: for each dot sub-string validate 	invalidate: 021 - when non-dot, leading zeros (if not '0')
	  							     01.23 - leading zeros in case of dot (first part)
	  						     	    1.230 - trailing zeros in case of dot (second part) 
	  step5: add all valid string to List "("+dx+", "+dy+")"
	
#876	Middle of LinkedList (E)
		
		Given a non-empty, singly linked list with head node head, return a middle node of linked list.
		If there are two middle nodes, return the second middle node.

		Example 1:
			Input: [1,2,3,4,5]
			Output: Node 3 from this list (Serialization: [3,4,5])
			The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
			Note that we returned a ListNode object ans, such that:
			ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
		Example 2:
			Input: [1,2,3,4,5,6]
			Output: Node 4 from this list (Serialization: [4,5,6])
			Since the list has two middle nodes with values 3 and 4, we return the second one.
			 
		Note:
		The number of nodes in the given list will be between 1 and 100.
		
		@2 ptrs (slow by 1; fast by 2)
		
#906. Super Palindromes (Hard)

	Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
	Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].

	Example 1:
	  Input: left = "4", right = "1000"
	  Output: 4
	  Explanation: 4, 9, 121, and 484 are superpalindromes.
	  Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.

	Example 2:
	  Input: left = "1", right = "2"
	  Output: 1
	@ [Observation]
	The range for P and Q is in between 1e18. So lets say R^2 is a super palindrome then it must lie between the given range,  

	We also know that super palindromes are made by squaring palindrome numbers then R must also be a Palindrome.
	if R^2 <=1e18 then R <=1e9 
	
	As we know R is a palindrome then its first half digits must be equal to other half right ?
	So.. here there can be two such possiblity if the total number of digits in R is even or it can be odd.

	Consider z = 1234 be its first half digits then its other half can be :
	R = 1234321 or 12344321 
	that means the first half digits in R can lie in the range of 1 to 1e5 (mostly less than 1e5 as R can be 1e9 )

	so we only have to iterate through 1e4 digits and concat and form R, now R is a palindrome, then check if R^2 is palindrome too if yes then thats our SUPER PALINDROME !! do (ans++;)

		
#953. Verifying an Alien Dictionary (Easy)

	In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. 
	The order of the alphabet is some permutation of lowercase letters.
	Given a sequence of words written in the alien language, and the order of the alphabet, 
	return true if and only if the given words are sorted lexicographicaly in this alien language.

	-------------
	Example 1:
	Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
	Output: true
	Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

	Example 2:
	Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
	Output: false
	Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

	Example 3:
	Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
	Output: false
	Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", 
		      because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
	@store mapping of each dictionary char to index,
	 and then check adjacent words if they are sorted lexicographically using the map we creted earlier.
	 
#970. Powerful Integers   (Medium)

	Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
	An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
	You may return the answer in any order. In your answer, each value should occur at most once.

	Example 1:
	  Input: x = 2, y = 3, bound = 10
	  Output: [2,3,4,5,7,9,10]
	  Explanation:
	  2 = 20 + 30
	  3 = 21 + 30
	  4 = 20 + 31
	  5 = 21 + 31
	  7 = 22 + 31
	  9 = 23 + 30
	  10 = 20 + 32

	Example 2:
	  Input: x = 3, y = 5, bound = 15
	  Output: [2,4,6,8,10,14]
	  
	@ store power of x & y in two different lists.
	when x = 2, y = 3, bound = 10: px = [1, 2, 4, 8] & py = [1, 3, 9]
	iterate over both the list, and sum it up if sum (x+y) <= bound and add it to the set (to avoid duplicates)
	
#1029. Two City Scheduling  (Medium)

	A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

	Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

	Example 1:
	  Input: costs = [[10,20],[30,200],[400,50],[30,20]]
	  Output: 110
	  Explanation: 
	  The first person goes to city A for a cost of 10.
	  The second person goes to city A for a cost of 30.
	  The third person goes to city B for a cost of 50.
	  The fourth person goes to city B for a cost of 20.

	  The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

	Example 2:
	  Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
	  Output: 1859

	Example 3:
	  Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
	  Output: 3086
  
 	@ iterate through 2D array, and add element into A_PQ (when a[0] is smaller) or B_PQ (when a[1] is smaller)
	Priority Queue i.e. min heap should store smaller difference first.
	when A_PQ > size/2, pop off A_PQ and add it into B_PQ and vice versa.
	at the end, iterate over A_PQ & B_PQ to accumulate the sum i.e. min cost.
	 
#1047. Remove All Adjacent Duplicates In String   (Easy)

	Given a string S of lowercase letters, a *duplicate* removal consists of choosing two adjacent and equal letters, and removing them.
	We repeatedly make duplicate removals on S until we no longer can.
	Return the final string after all such duplicate removals have been made.  
	It is guaranteed the answer is unique.

	Example 1:
	  Input: "abbaca"
	  Output: "ca"
	  Explanation: 
	  For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move. stac 
	  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
	@Use stack, and while adding new element to the stack, (check if top of the stack & current element is same), simply pop and proceed ahead
	
#1048. Longest String Chain   (Medium)

	Given a list of words, each word consists of English lowercase letters.

	Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2. 
	For example, "abc" is a predecessor of "abac".

	A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2,
	word_2 is a predecessor of word_3, and so on.

	Return the longest possible length of a word chain with words chosen from the given list of words.

	Example 1:
		Input: words = ["a","b","ba","bca","bda","bdca"]
		Output: 4
		Explanation: One of the longest word chain is "a","ba","bda","bdca".

	Example 2
		Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
		Output: 5
	
	@ Sort the array based on array length (ascending)
	Iterate through words 
		Take the predecessor = (s.substring(0,i)+s.substring(i+1, length())
		longestNo = Math.max(longestNo, map.getOrDefault(predecessor, 0)+1)
	map.put(word, longestNo)
	ans = Math.max(ans, longestNo);
	return ans
	
#1074. Number of Submatrices That Sum to Target (Hard)

	Given a matrix and a target, return the number of non-empty submatrices that sum to target.

	Example 1:
	  0   1   0
	  1   1   1
	  0   1   0
	  Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
	  Output: 4
	  Explanation: The four 1x1 submatrices that only contain 0.

	Example 2:
	  1   -1
	  -1   1
	  Input: matrix = [[1,-1],[-1,1]], target = 0
	  Output: 5
	  Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.

	Example 3:
	  Input: matrix = [[904]], target = 0
	  Output: 0
	  @ This problem is a variation of 1D SubArraySum Target 
	  	For each row, calculate the prefix sum.
		For each pair of columns, calculate the accumulated sum of rows.
		Now this problem is same to, "Find the Subarray with Target Sum". (LC#560)
		
#1143. Longest Common Subsequence (Medium)
	
	Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
	A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
    	For example, "ace" is a subsequence of "abcde".

	A common subsequence of two strings is a subsequence that is common to both strings.
	
	Example 1:
		Input: text1 = "abcde", text2 = "ace" 
		Output: 3  
		Explanation: The longest common subsequence is "ace" and its length is 3.

	Example 2:
		Input: text1 = "abc", text2 = "abc"
		Output: 3
		Explanation: The longest common subsequence is "abc" and its length is 3.

	Example 3:
		Input: text1 = "abc", text2 = "def"
		Output: 0
		Explanation: There is no such common subsequence, so the result is 0.
	@ Memoization & DP
	if(both chars match), increment the value  1 + (i-1, j-1)
	else use the Max of adjacent cells (i-1, j) & (i, j-1)
	
#1209. Remove All Adjacent Duplicates in String II	(Medium)

	You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, 
	causing the left and the right side of the deleted substring to concatenate together.
	We repeatedly make k duplicate removals on s until we no longer can.
	Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

	Example 1:
	  Input: s = "abcd", k = 2
	  Output: "abcd"
	  Explanation: There's nothing to delete.

	Example 2:
	  Input: s = "deeedbbcccbdaa", k = 3
	  Output: "aa"
	  Explanation: 
	  First delete "eee" and "ccc", get "ddbbbdaa"
	  Then delete "bbb", get "dddaa"
	  Finally delete "ddd", get "aa"

	Example 3:
	  Input: s = "pbbcggttciiippooaais", k = 2
	  Output: "ps"
	@Stack<int[]>: int[] stores character[0] & its frequency[1], when frequency[1]==k, pop the element & return str.reverse() at the end
	
#1302. Deepest Leaves Sum   (Medium)

	Given the root of a binary tree, return the sum of values of its deepest leaves. 
	Example1:
		Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
		Output: 15

	Example 2:
		Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
		Output: 19
	
	@Using BFS, traverse each level of the Tree and keep accumulating sum at each level. (reset before visiting next level)
	and return the last level sum.
		
#1342	Number of Steps to Reduce a Number to Zero (E)

	Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

	Example 1:

	Input: num = 14
	Output: 6
	Explanation: 
		Step 1) 14 is even; divide by 2 and obtain 7. 
		Step 2) 7 is odd; subtract 1 and obtain 6.
		Step 3) 6 is even; divide by 2 and obtain 3. 
		Step 4) 3 is odd; subtract 1 and obtain 2. 
		Step 5) 2 is even; divide by 2 and obtain 1. 
		Step 6) 1 is odd; subtract 1 and obtain 0.
		
	@ while num is +ve, (if even, divide by 2 else deduct 1) and increment counter
	
#1354. Construct Target Array With Multiple Sums  (Hard)

	Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :

    let x be the sum of all elements currently in your array.
    choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
    You may repeat this procedure as many times as needed.

	Return True if it is possible to construct the target array from A otherwise return False.

	Example 1:
	Input: target = [9,3,5]
	Output: true
	Explanation: Start with [1, 1, 1] 
	[1, 1, 1], sum = 3 choose index 1
	[1, 3, 1], sum = 5 choose index 2
	[1, 3, 5], sum = 9 choose index 0
	[9, 3, 5] Done

	Example 2:
	Input: target = [1,1,1,2]
	Output: false
	Explanation: Impossible to create target array from [1,1,1,1].

	Example 3:
	Input: target = [8,5]
	Output: true
	
	@ Start backwards (From target and reach it [1, 1 ...]
	Use Priority Queue (Max heap), store all target array to PQ (also maintains totalSum).
	poll the max element,set remainingSum = totalSum - maxElement
	update newElem (to be added to PQ) as maxElement%remainingSum
	also update totalSum = newElem + remainingSum
	
	if at any point in time, maxElement=1 or remainingSum=1 => return true
	or else if maxElement < remainingSum or remaininSum=0 => return false

#1423. Maximum Points You Can Obtain from Cards	(Medium)

	There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.
	In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
	Your score is the sum of the points of the cards you have taken.

	Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

	Example 1:
	  Input: cardPoints = [1,2,3,4,5,6,1], k = 3
	  Output: 12
	  Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score.
	  The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

	Example 2:
	  Input: cardPoints = [2,2,2], k = 2
	  Output: 4
	  Explanation: Regardless of which two cards you take, your score will always be 4.

	Example 3:
	  Input: cardPoints = [9,7,7,9,7,7,9], k = 7
	  Output: 55
	  Explanation: You have to take all the cards. Your score is the sum of points of all cards.

	Example 4:
	  Input: cardPoints = [1,1000,1], k = 1
	  Output: 1
	  Explanation: You cannot take the card in the middle. Your best score is 1. 
	  
	@ Since we're forced to take K amount of cards no matter what, we can solve this problem with a two-pointer system with a sliding window approach.
	Instead of counting the sum of the values between the two pointers, we'll instead be counting the sum of the values outside the sliding window.

	We can start by iterating through the first K cards of our card list (C) and finding the total points. At this point, our reverse window will be the cards from i = K to j = C.length - 1. 
	At each iteration, we'll slide the window backwards, removing one card from the left side (-C[i]) and adding one card from the right side (+C[j]) each time.

We should keep track of the best possible result at each iteration, then return best once we reach the end.

#1450	Number of Students Doing Homework at a Given Time (E)

	Given two integer arrays startTime and endTime and given an integer queryTime.
	The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
	Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
	
	Example 1:
		Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
		Output: 1
		Explanation: We have 3 students where:
		The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
		The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
		The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.

	Example 2:
		Input: startTime = [4], endTime = [4], queryTime = 4
		Output: 1
		Explanation: The only student was doing their homework at the queryTime.

	Example 5:
		Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
		Output: 5
		
#1480. Running Sum of 1d Array  (Easy)

	Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
	Return the running sum of nums.

	Example 1:
	  Input: nums = [1,2,3,4]
	  Output: [1,3,6,10]
	  Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

	Example 2:
	  Input: nums = [1,1,1,1,1]
	  Output: [1,2,3,4,5]
	  Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

	Example 3:
	  Input: nums = [3,1,2,10,1]
	  Output: [3,4,6,16,17]
	  
	@ Simple: extra space
		Keep accumulating sum at each iteration, store that accumulated sum to resultant_array[i]
	w/o additional space:
		input_arr[i] = input_arr[i-1] + input_arr[i]; (starts from i=1; i<length; i++) 
	
#1551. Minimum Operations to Make Array Equal (Medium)

	You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
	In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] 
	(i.e. perform arr[x] -=1 and arr[y] += 1). 
	The goal is to make all the elements of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.
	Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.

	Example 1:
		Input: n = 3
		Output: 2
		Explanation: arr = [1, 3, 5]
		First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
		In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].

	Example 2:
		Input: n = 6
		Output: 9

	@ 
`	
   	There are two possible cases

    n is odd, let's consider n=5.
	array contains
	1 3 5 7 9

		Here, middle element of array is -> 5.
		Now, we need to choose elements in a pair (which are not equal to the mid element), perform some operation on a pair to make them equal to middle element.
		Let's take pair (3,7) ,We will decrement 7 and incement 3, two times to make them equal to 5(middle element): So it takes 2 steps.
		Let's take another pair (1,9) We will decrement 9 and incement 1, four times to make them equal to 5: So it takes 4 steps.
		After performing these steps, all elements will become 5.
		So, Total steps: 2+4=6. (sum of first n/2 even numbers)
		Sum of first k EVEN numbers = k(k+1)
		ans would be n/2(n/2+1)

	n is even, let's consider n=6.
	array contains
	1 3 5 7 9 11

	    Here, middle element of array is -> (5+7)/2=6.
	    Let's take pair (5,7), We will decrement 7 and incement 5, one time to make them equal to 6: So it takes 1 step.
	    Let's take 2nd pair (3,9), We will decrement 9 and incement 3, three times to make them equal to 6: So it takes 3 steps.
	    Let's take last pair (1,11), We will decrement 11 and incement 1, five times to them equal to 6: So it takes 5 steps.
	    After performing these steps, all elements will become 6:
	    Total steps: 1+3+5=9. (sum of first n/2 odd numbers)
	    Sum of first k ODD numbers = k*k.
	    ans would be n/2*n/2

	
#1642. Furthest Building You Can Reach  (Medium)

	You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
	You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

	While moving from building i to building i+1 (0-indexed),
	    If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
	    If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.

	Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.

	Example 1:
	  Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
	  Output: 4
	  Explanation: Starting at building 0, you can follow these steps:
	  - Go to building 1 without using ladders nor bricks since 4 >= 2.
	  - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
	  - Go to building 3 without using ladders nor bricks since 7 >= 6.
	  - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
	  It is impossible to go beyond building 4 because you do not have any more bricks or ladders.

	Example 2:
	  Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
	  Output: 7

	Example 3:
	  Input: heights = [14,3,19,3], bricks = 17, ladders = 0
	  Output: 3
	@Ladders have adjustable height (use for larger height/climb)... For K Largest climbs, use ladder
	whereas Bricks has a height of 1 unit (Use for shorter height/climb)...for others use bricks until it gets exhausted
	When Height to climb is greater than K highest climbs, swap ladder with bricks for the lower heights. If possible, climb further else return current idx
	Use Priority Queue/Min Heap
	
#1704. Determine if String Halves Are Alike   (Easy)

	You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
	Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). (Notice that s contains uppercase and lowercase letters.)
	Return true if a and b are alike. Otherwise, return false

	Example 1:
		Input: s = "book"
		Output: true
		Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

	Example 2:
		Input: s = "textbook"
		Output: false
		Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike. (Notice that the vowel o is counted twice)
		
	@identify the size to split into two halves (or use 2 ptr technique)
         iterate through first half (also maintains vowelCntS1)
	 assign slow++ to fast and iterate through second half (and maintain vowelsCntS2)
