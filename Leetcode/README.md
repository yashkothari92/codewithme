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
	
#100 Same Tree (E)

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
		
#108	Convert Sorted Array to Binary Search Tree (E)

	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	Given the sorted array: [-10,-3,0,5,9],

	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

	      0
	     / \
	   -3   9
	   /   /
	 -10  5
	 
	 @recursion, root (middle); root.left(start, middle-1); root.right(middle+1, end)
	 
#109	Convert Sorted List to Binary Search Tree (M)
	
	Same question as above, only change is input (here its LinkedList as opposed to an array)
	
	@find middle node using two pointers, and assign root
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
		
#206	Reverse Linked List (E)

		Example:
			Input: 1->2->3->4->5->NULL
			Output: 5->4->3->2->1->NULL
			
			@current, next, prev
			
#225	Implement Stack using Queues (E)

		@take 2 queues
		dump all elements of Q1 to Q2 until Q1.size == 1
		pop last element of Q1 -> store and return 
		and swap Q1 & Q2
		
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

#622	Design Circular Queue (Medium)
	
	Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO  principle and 
	the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
	
	@Used LinkedList (both head & tail) data-structure to implement Circular Queue operations.
	
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
		
LC#1551. Minimum Operations to Make Array Equal (Medium)

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

	@ n=3 where a[i] = 2*i+1
	we will iterate until mid point (n), and add result of (a[i]-n) at each i until i > n.
	[1, 3, 5] for n=3 will have mid point 3 (i.e. all array elements could get equal to 3)
	[1, 3, 5, 7] for n=4 will have mid point 4 (i.e. all array elements could get equal to 4)
	[1, 3, 5, 7, 9] for n=5 will have mid point 5 (i.e. all array elements could get equal to 5)
	
LC#1704. Determine if String Halves Are Alike   (Easy)

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
