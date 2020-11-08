package tree;

import java.util.LinkedList;
import java.util.Queue;

//[10, 5, 15, 6, 1, 8, 12, 18, 17]
//		10 
//	  /	  	\
//	 5     	15
//	/ \     /  \
//	1	6  12  18
//		 \     /
//		 8   17

public class BuildBST {
	Node root;
	
	// add node to the Binary Tree 
	public void add (int data){ 
		Node newNode = new Node(data);
		
		if(root == null) {
			root = newNode;
			return;
		} 
		Node temp = root;
		
		while(temp != null) {
			if (data < temp.data) {
			
				Node left = temp.left;
				if(left == null) {
					temp.left = newNode;
					return;
				}
				temp = temp.left;			
			}
		
			if (data > temp.data) {
				Node right = temp.right;
				if(right == null) {
					temp.right = newNode;
					return;
				}
				temp = temp.right;			
			}
		}
	}

	public int minimum() {
		return minimum(root);
	}
	
	private int minimum(Node root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		if(root.left == null && root.right == null) {
			return root.data;
		}
		
		int left = minimum(root.left);
		int right = minimum(root.right);
		
		return Math.min(Math.min(left, right), root.data);
	}
	
	// height of a tree
	public int height() {
		return height(root);
	}
	
	private int height(Node root) {
		if(root == null) {
			return -1;
		}
		
		if(root.left == null && root.right == null) {
			return 0;
		}
		
		int h = 1 + Math.max(height(root.left), height(root.right));
		return h;
	}
	
	// traverses tree 
	public void displayTree() {
		
		// pre-order traversal
		System.out.println("***Preorder***");
		preorder(root);
		System.out.println("\n***Inorder***");
		inorder(root);
		System.out.println("\n***Postorder***");
		postorder(root);
		
		// level order traversal
		System.out.println("\n***Level Order Traversal***");
		levelOrderTraversal(root);
	}
	
	private void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int nodes = queue.size();
			while(nodes > 0) {
				Node tmpNode = queue.poll();
				System.out.print(tmpNode.data+" ");
	
				if(tmpNode.left != null) {
					queue.add(tmpNode.left);
				}
				
				if(tmpNode.right != null) {
					queue.add(tmpNode.right);
				}
				nodes--;
			}
			System.out.println();
		}	
	}
	
	private void postorder(Node root) {
		// base condition
		if(root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);		
		System.out.print(root.data+" ");
	}

	private void inorder(Node root) {
		// base condition
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);	
	}

	private void preorder(Node root) {
		// base condition
		if(root == null) {
			return;
		}
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

	public boolean equal(BuildBST other) {
		if(other == null)
			return false;
		
		return equal(root, other.root);
	}

	private boolean equal(Node orig, Node bkp) {
		if(orig == null && bkp == null)
			return true;
		
		if(orig != null && bkp != null) {
			return (orig.data == bkp.data) &&
					equal(orig.left, bkp.left) &&
					equal(orig.right, bkp.right);
		}
		
		return false;
	}

	/*public String isBST() {
		return isBST(root);
	}*/

	private String isBST(Node root) {
		
		return null;
	}
}
