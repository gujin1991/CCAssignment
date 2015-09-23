package Coding.Boot.Camp;

import java.util.*;




public class Solution05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution05 s = new Solution05();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		System.out.println(s.isValidataBST(root));
	}
	
	/*in this problem, we recursively check if the value of current node is smaller than value of right subtree
	 * and bigger than value of left subtree. Then we update the minimum and maximum.
	 */
	public boolean isValidataBST(TreeNode node) {
		return checkBST(node, null, null);
	}
	
	public boolean checkBST(TreeNode node, Integer min, Integer max) {
		if(node == null) return true;
		
		
		if((min != null && node.val <= min)|| (max != null && node.val > max)) {
			return false; 
		}
		
		//update the minimum and maximum
		if(!checkBST(node.left, min, node.val) || !checkBST(node.right, node.val, max)) {
			return false;
		}
		
		return true;
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
					current.add(parent.left);
				} else{
					break;
				}
				if(++index < arr.length) {
					parent.right = new TreeNode(arr[index]);
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
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
