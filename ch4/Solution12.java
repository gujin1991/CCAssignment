package Coding.Boot.Camp;

import java.util.LinkedList;


public class Solution12 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution12 s = new Solution12();
		int arr[] = {1, 2, 3, 4, 6, 5, 7};
		TreeNode root = s.buildTree(arr); //build a three layer binary tree
		
		System.out.println(s.pathSum(root, 9)); //it should be 2.
	}
	
	/*in this problem, we recursively add the path started from root node, and then make
	 * the children of current node to be root node
	 */
	public int pathSum(TreeNode root, int sum) {
		if(root == null) return 0;
		int rootcount = pathSumFromRoot(root, sum, 0);
		int lcount = pathSum(root.left, sum);
		int rcount = pathSum(root.right, sum);
		
		
		return rootcount + lcount + rcount;
	}
	
	public int pathSumFromRoot(TreeNode root, int sum, int currentSum) {
		if(root == null) return 0;
		int count = 0;
		
		//check if the current sum is equal to the target sum
		currentSum += root.val;
		if(currentSum == sum) {
			count++;
		} else {
			count += pathSumFromRoot(root.left, sum, currentSum);
			count += pathSumFromRoot(root.right, sum, currentSum);
		}
		
		return count;
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
