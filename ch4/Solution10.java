package Coding.Boot.Camp;

import java.util.LinkedList;


public class Solution10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution10 s = new Solution10();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		System.out.println(s.findSubTree(root, root.right.left));
	}
	
	/*in this problem, we traverse the tree ,if we reach a node which is equal to the target node, 
	 * we check if the rest nodes of two subtree are the same.
	 */
	public boolean isSubTree(TreeNode t1, TreeNode t2) {
		if(t2 == null) return true;
		return findSubTree(t1,t2);
	}
	
	public boolean findSubTree(TreeNode t1, TreeNode t2) {
		if(t1 == null) return false;
		if(t1.val == t2.val && match(t1, t2)) {
			return true;
		}
		return findSubTree(t1.right, t2) || findSubTree(t1.left, t2);
		
	}
	
	//check if the rest nodes of two subtree are the same
	public boolean match(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		
		if(t1.val != t2.val) {
			return false;
		} else {
			return match(t1.left, t2.left) && match(t1.right, t2.right);
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
