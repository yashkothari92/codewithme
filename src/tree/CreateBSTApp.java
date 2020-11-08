package tree;

// [10, 5, 15, 6, 1, 8, 12, 18, 17]
//        10
//      /    \
//     5     15
//	  / \    / \
//   1	 6  12 18
//        \    /
//         8  17

public class CreateBSTApp {

	public static void main(String[] args) {
		BuildBST obj = new BuildBST();
//		obj.add(10);
//		obj.add(5);
//		obj.add(15);
//		obj.add(6);
//		obj.add(1);
//		obj.add(8);
//		obj.add(12);
//		obj.add(18);
//		obj.add(17);
		obj.add(20);
		obj.add(10);
		obj.add(30);
		obj.add(1);
		obj.add(24);
		obj.add(14);
		obj.add(26);
		obj.add(8);
		obj.add(3);
		
		BuildBST obj2 = new BuildBST();
		obj2.add(20);
		obj2.add(10);
		obj2.add(30);
		obj2.add(6);
		obj2.add(24);
		obj2.add(14);
		obj2.add(26);
		obj2.add(8);
		obj2.add(3);
		
		// Breadth first search (Level order traversal)
		// Depth first search (Preorder, Postorder, Inorder)
		obj.displayTree();
		 
		// height & (depth)
		System.out.println("height:"+obj.height());
		
		// smallest element in a tree
		System.out.println("Minimum:"+obj.minimum());
		
		// validates if two trees are equal
		System.out.println("Equals:"+obj.equal(null));
		
		// validates if binary tree is BST
		//System.out.println("isBST:"+obj.isBST());

	}
}
