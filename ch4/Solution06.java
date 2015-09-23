package Coding.Boot.Camp;

import java.util.*;


public class Solution06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution06 s = new Solution06();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		TreeNode node = s.successor(root.left);
		System.out.println(node.val); // it should be 5
	}
	
	/*suppose we traverse the tree in inorder, then we should return the leftmost node of right subtree.
	 * if there is no such a node, we return the parent node when current node is left node of parent node. 
	 */
	public TreeNode successor(TreeNode node) {
		if(node == null) return null;
		if(node.right != null) {
			// get leftmost node of right subtree
			TreeNode p = node.right;
			while(p.left != null) {
				p = p.left;
			}
			return p;
		} else {
			//find the parent node when current node is left node of parent node
			while(node.parent.right == node && node.parent != null) {
				node = node.parent;
			}
			return node.parent;
		}
	}
	
	
	public TreeNode buildTree(int arr[]) {
		if(arr.length == 0) return null;
		
		TreeNode root = new TreeNode(arr[0]);
		int index = 0;
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		while(index < arr.length -1) {
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent: parents) {
				if(++index < arr.length) {
					parent.left = new TreeNode(arr[index]);
					parent.left.parent = parent;
					current.add(parent.left);
				} else{
					break;
				}
				if(++index < arr.length) {
					parent.right = new TreeNode(arr[index]);
					parent.right.parent = parent;
					current.add(parent.right);
				} else{
					break;
				}
			}
		}
		
		return root;
	}
	
	private class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
}
